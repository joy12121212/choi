package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;



@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
    // 회원가입
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
