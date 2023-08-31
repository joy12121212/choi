package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;



@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
    // 회원가입(첨부파일 있을때)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//첨부파일 저장할 폴더의 절대 경로
    	String uploadpath = request.getServletContext().getRealPath("/member/img");	// 첨부 파일을 저장할 경로
    	
    	//첨부파일 전송 했을때
    		// 1. 첨부파일 서버pc에 업로드 (cos 라이브러리)
    			MultipartRequest multi = new MultipartRequest(
    					request , 			// 요청 방식
    					uploadpath ,		// 첨부파일을 저장할 폴더 경로
    					1024*1024*10,		// 첨부파일 용량 허용 범위 10MB
    					"UTF-8",			// 한글 인코딩
    					new DefaultFileRenamePolicy()	// 만약에 서버내 첨부파일중 동일한 이름이 있으면 뒤에 숫자 붙임
    					);
    	
    		// 2. form 안에 있는 각 데이터 호출
    	
    	// 1 form 객체 전송시 input name 을 써야 됨 //class 안됨
    	String mid = multi.getParameter("mid");	System.out.println("컨트롤러 imd : " + mid);
    	String mpwd = multi.getParameter("mpwd");
    	String memail = multi.getParameter("memail");
    	String mimg = multi.getFilesystemName("mimg"); System.out.println("컨트롤러 mimg : " + mimg);
    	

    	System.out.println(mid + mpwd + memail + mimg);
    	// 객체화 
    	MemberDto memberDto = new MemberDto(mid , mpwd , memail , mimg);
    	boolean result = MemberDao.getInstance().signup(memberDto);
    	
    	response.setContentType("application/json; charset=UTF-8");
    	response.getWriter().print(result);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request, response);
	
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}


/*

// 회원가입 ( 첨부파일 없을때 )
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 1 아작스 통신 받은 데이터의 속성명 요청한다
	String mid = request.getParameter("mid");
	String mpwd = request.getParameter("mpwd");
	String memail = request.getParameter("memail");
	String mimg = request.getParameter("mimg");
	

	System.out.println(mid + mpwd + memail + mimg);
	// 객체화 
	MemberDto memberDto = new MemberDto(mid , mpwd , memail , mimg);
	boolean result = MemberDao.getInstance().signup(memberDto);
	
	response.setContentType("application/json; charset=UTF-8");
	response.getWriter().print(result);
}





*/

