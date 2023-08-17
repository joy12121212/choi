package test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Test05
 */
@WebServlet("/Test05")
public class Test05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

    public Test05() {
        super();

    }
    
    
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDto boardDto = new BoardDto("제목2", "안녕하세요2");
		// dto json 변환 [ js 에게 데이터 전달하는데.. js 는 dto 타입을 모르지] 번역이 필요함
			// java가 문자열타입의 json 모양 만들어서 js에게 전달
			// json 변환 라이브러리 
				//objectMapper 클래스 : java 객체를 json 형식으로 변환해주는 함수를 제공하는 라이브러리
		//1. dto --> json 변환 해주는 변환객체
		ObjectMapper mapper = new  ObjectMapper();
		String jsonData = mapper.writeValueAsString(boardDto); // json 형식으로 변환할 객체 넣기
		System.out.println("자바에서 json 으로 변환해주는 라이브러리 " + jsonData);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonData);
		
	}

	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
