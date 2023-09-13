package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.dto.ProductDto;



@WebServlet("/productInfoController")
public class productInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public productInfoController() {super();}


    // 제품 등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// commons 라이브러리 이용한 업로드 구현
    	
    	// 1. 저장경로 [ 첨부파일이 저장 될 폴더 위치 ]
    	String uploadPath = request.getServletContext().getRealPath("/product/img");
    	System.out.println("경로" +uploadPath);
    	// 2. 파일아이템 저장소 객체 // 톰캣 없는거
    	DiskFileItemFactory itemFactory = new DiskFileItemFactory();
    	itemFactory.setRepository(new File(uploadPath)); // 저장위치
    	itemFactory.setSizeThreshold(1020*1024*1024);	// 용량
    	itemFactory.setDefaultCharset("UTF-8");			// 한글인코딩
    	
    	// 3. 파일 업로드 객체 // 2번과 3번은 세트다	// form 전송시 input 태크 모든 데이터 다 가져옴
    	ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
    	System.out.println(fileUpload);
    	// 4. 파일 업로드 요청[ 요청방식 : request ]
    	try {
    		
    		Map<Integer, String> imgList = new HashMap<>();
    		System.out.println(imgList);
			List<FileItem> fileList = fileUpload.parseRequest(request);
			System.out.println("fileList" + fileList);
			// 5. 업로드 실행
			int i = 0;
			for (FileItem item : fileList) {// 요청한 input 들의 데이터를 반복문으로 하나씩 꺼내기
				// 1. 일반 필드		isFormField() : 일반 form 필드이면 true / 첨부파일이면 false
				if(item.isFormField()) {
					
					
				}
				// 2. file 필드
				else {
					// 만약에 파일 필드이며 업로드 진행
					File fileUploadPath = new File(uploadPath+"/"+item.getName());
					System.out.println("업로드경로와 파일명 조합 : " + fileUploadPath);

					item.write(fileUploadPath); // 파일 업로드할 경로를 file 타입으로 제공
					i++;
					imgList.put(i, item.getName()); // 키값을 왜 써요? 호출 목적으로 0 넣은거 // 키: 이미지번호 , 값 : 이미지이름
					System.out.println(imgList.put(i, item.getName()));
				}
			}
			
	    	ProductDto productDto = new ProductDto(
	    			Integer.parseInt( fileList.get(0).getString()),
	    			fileList.get(1).getString(),
	    			fileList.get(2).getString(),
	    			Integer.parseInt(fileList.get(3).getString()),
	    			null,
	    			null, 
	    			0,
	    			imgList);
	    	System.out.println(productDto);
			
		} catch (Exception e) {System.out.println("여기서 오류나 : " + e);}
    	

    }//doPost
    
    
    // 제품 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	// 제품 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	// 제품 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}


/*
    	MultipartRequest multi = new MultipartRequest(
    			request,
    			request.getServletContext().getRealPath("/product/img"),
    			1024*1024*1024,
    			"UTF-8",
    			new DefaultFileRenamePolicy()    			
    			);
    	String pcno = multi.getParameter("pcno");
    	String pname = multi.getParameter("pname");
    	String pcontent = multi.getParameter("pcontent");
    	String pprice = multi.getParameter("pprice");
    		// 만약에 첨부파일 2개 이상일경우 ? 어떻게 호출 ?
    	String pimg = multi.getFilesystemName("pimg");
    		// getFilesystemName() 얘는 1개 밖에 안됨
    	Enumeration pimg1 = multi.getFileNames();
    		System.out.println(pimg1);
*/
