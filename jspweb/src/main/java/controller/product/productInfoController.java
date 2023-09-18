package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.ProductDao;
import model.dto.MemberDto;
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

    	// 4. 파일 업로드 요청[ 요청방식 : request ]
    	try {
    		
    		Map<Integer, String> imgList = new HashMap<>();
    		System.out.println("이미지리스트 맵 " + imgList);
			
    		List<FileItem> fileList = fileUpload.parseRequest(request);
			System.out.println("fileList" + fileList);
			
			// 5. 업로드 실행
			int i = 0;
			for (FileItem item : fileList) {// 요청한 input 들의 데이터를 반복문으로 하나씩 꺼내기
				// 1. 일반 필드		isFormField() : 일반 form 필드이면 true / 첨부파일이면 false
				if(item.isFormField()) {}
				// 2. file 필드
				else {
					
					UUID uuid = UUID.randomUUID();
						//uuid 클래스 : 공유성을 보장하는 id 를 만들기 위한 식별자 표순 규약
					String filename = uuid + "-"+item.getName().replaceAll("-", "_");
						// 만약에 파일명에 - 존재하면 _ 변경
					
					// 만약에 파일 필드이며 업로드 진행
					File fileUploadPath = new File(uploadPath+"/"+filename);


					item.write(fileUploadPath); // 파일 업로드할 경로를 file 타입으로 제공
					i++;
					imgList.put(i, filename); // 키값을 왜 써요? 호출 목적으로 0 넣은거 // 키: 이미지번호 , 값 : 이미지이름

					// map 컬렉션은 키와 값으로 구성된 엔트리 [ 키는 중복 불가능 ]
				}
			}
			// fileItem 으로 가져온 데이터들을 각 필드에 맞춰서 제품Dto에 저장하기
			// 로그인된 회원번호
			int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
			
	    	ProductDto productDto = new ProductDto(
	    			Integer.parseInt( fileList.get(0).getString()),
	    			fileList.get(1).getString(),
	    			fileList.get(2).getString(),
	    			Integer.parseInt(fileList.get(3).getString()),
	    			fileList.get(4).getString(),
	    			fileList.get(5).getString(),
	    			mno,
	    			// 여러개 이미지는 위에서 리스트로 구성 후 대입
	    			// 업로드한 파일명의 개수만큼 map 리스트
	    			imgList);
	    	System.out.println(productDto);
		
	    	boolean result = ProductDao.getInstance().register(productDto);
	    	
	    	response.setContentType("application/json;charset=UTF-8");
	    	response.getWriter().print(result);
	    	
		} catch (Exception e) {System.out.println("여기서 오류나 : " + e);}
    	

    }//doPost
    
    
    // 제품 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");

		String json = "";	// DAO로부터 응답된 결과를 JSON형식의 문자열 타입을 저장하는 변수 
		ObjectMapper mapper = new ObjectMapper(); 
		
		
		if( type.equals("findByTop") ){ 
			int count = Integer.parseInt( request.getParameter("count") );
			List<ProductDto> result =  ProductDao.getInstance().findByTop( count );
			json = mapper.writeValueAsString(result);
		}
		else if( type.equals("findByLatLng") ) 	{ 
			System.out.println("지도 컨트롤러 실행");
			String east = request.getParameter("east");		String west = request.getParameter("west");
			String south = request.getParameter("south");	String north = request.getParameter("north");
			List<ProductDto> result = ProductDao.getInstance().findByLatLng(east, west, south, north);
			json = mapper.writeValueAsString(result);

		}
		else if( type.equals("findByPno") ) 	{ 
			int pno = Integer.parseInt( request.getParameter("pno") );
			ProductDto result = ProductDao.getInstance().findByPno( pno );
			json = mapper.writeValueAsString(result);
		}
		else if( type.equals("findByAll") ) 	{ 

			List<ProductDto> result = ProductDao.getInstance().findByAll();	
			json = mapper.writeValueAsString(result);

		}

		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( json );


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
