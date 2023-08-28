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
		System.out.println("doget 실행");
		// 요청
		
		String type = request.getParameter("type");
		String data = request.getParameter("data");
		
		// 객체화 / 유효성 검사
		// 다오 요청 결과
		boolean result = MemberDao.getInstance().findIdOrEmail(type , data);		
		// 결과 전달
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		this.doPost(request, response);
		System.out.println("AAA");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("AA");
	}

}
