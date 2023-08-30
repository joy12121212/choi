package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class MemberFindController
 */
@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberFindController() {
        super();
        // TODO Auto-generated constructor stub
    }
    	// 메소드 하나에 ajax 여러개 쓰려면 type 정송
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		
		String type = request.getParameter("type"); 
		String data = request.getParameter("data");
		
		// 객체화 / 유효성 검사
		// 다오 요청 결과
		boolean result = MemberDao.getInstance().findIdOrEmail(type , data);		
		// 결과 전달
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 매개변수 요청
		String mid=request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		System.out.println(mid + mpwd);
		
		
		// 2. 객체화 유효성 검사
		
		// 3. dao 에게 전달 후 결과 받기
		boolean result = MemberDao.getInstance().login(mid, mpwd);
		
		// 4. 결과 응답
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
	}

}

















