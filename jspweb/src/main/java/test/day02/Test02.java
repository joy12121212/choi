package test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test02") // 해당 클래스의 url 매핑[연결] 해주는 어노테이션[주석]
public class Test02 extends HttpServlet {
	// HttpServlet 클래스로부터 상송 받으면 해당 웹 관련 기능 제공 [ 멀티 스레드 , 예외처리 , Rest ]

	// 자바서블릿은? HTTP 기반으로 만들어진 클래스다
	
	// 브라우저[크롬,엣지 등] 에서 주소를 입력해서 웹 사이트에 접속하는 방식
	// http://www.naver.com  => get 방식
		//http 메소드
			// get : 호출 , post : 저장 , put : 수정 , delete : 삭제
	
	private static final long serialVersionUID = 1L;
       

    public Test02() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 콘솔 출력
		System.out.println("콘솔 출력");
		// 웹 출력
		response.getWriter().append("hello js ");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
