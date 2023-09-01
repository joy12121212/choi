package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dto.BoardDto;
import model.dto.MemberDto;

@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardInfoController() {
        super();

    }
    	// 쓰기
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// 첨부파일 업로드(있을경우)
    	MultipartRequest multi = new MultipartRequest(
    			request, 
    			request.getServletContext().getRealPath("board/upload"),	//저장경로
    			1020*1024*1024,		// 용량 1기가
    			"UTF-8",			// 인코딩 타입
    			new DefaultFileRenamePolicy() 
    			);
    	
    	System.out.println(request.getServletContext().getRealPath("board/upload"));
    	// 입력받은 매개변수 요청
    	
    	String btitle = multi.getParameter("btitle"); System.out.println(btitle);
    	String bcontent = multi.getParameter("bcontent");
    	String bfile = multi.getFilesystemName("bfile");
    	int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
    	int bcno = Integer.parseInt(multi.getParameter("bcno"));
    	
    	// 유효성검사/ 객체화
    	BoardDto boardDto = new BoardDto(btitle, bcontent , bfile , mno , bcno);
    	System.out.println(boardDto);
    	// 다오
    	
    	// 다오 응답
    	
    	
    	
    }
    
    
    
    
    
    	// 전체, 개별 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
		// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

		// 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}