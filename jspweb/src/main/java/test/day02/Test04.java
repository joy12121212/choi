package test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test04
 */
@WebServlet("/Test04")
public class Test04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test04() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// josn 타입 모양의 문자열
		String jsonData ="{\"title\" : \"제목\" , \"content\" : \"안녕하세요\"}";
		// 1. json 타입
		// 2. 전송 / 응답할 데이터	
		response.setContentType("application/json;charset=UTF-8");	// 객체 생성 가능 . 사용
		//response.setContentType("text/html;charset=UTF-8");		// 객체 생성 불가 . 못씀
		
		response.getWriter().print(jsonData);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
