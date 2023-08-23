package controller.visitlog;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.mapper.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.VisitlogDao;
import model.dto.VisitlogDto;


@WebServlet("/VisitlogController")
public class VisitlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VisitlogController() {super();}

    // 1. 저장
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 1. ajax 의 data 속성에 있는 객체정보(속성명 활용)를 호출하기
    		//request.getParameter("객체의 속성명");
    	String vwriter = request.getParameter("vwriter"); System.out.println("vwriter : " + vwriter);
    	String vpwd =  request.getParameter("vpwd");System.out.println("vpwd : " + vpwd);
    	String vcontent = request.getParameter("vcontent");System.out.println("vcontent : " + vcontent);

    // 2. 객체화
    	VisitlogDto visitlogDto = new VisitlogDto(vwriter , vpwd , vcontent);
    	System.out.println(visitlogDto);
    	
    // 3. dao 객체 전달 후 결과 응답 받기
    	boolean result = VisitlogDao.getInstance().vwrite(visitlogDto);
    	
    // 4. 결과를 ajax 에게 돌려주기
    	//response.getWriter().print(응답할 데이터);
    	
        //response.setContentType("text/html;charset=UTF-8");
    	response.setContentType("application/json;charset=UTF-8"); // js에서 boolea 값으로 리턴 받을 수 있음//객체로 보냄
    	response.getWriter().print(result); // 이걸 보내면 문자 true 로 들어간다 // 기본타입은 문자열임
    
    }

    // 2. 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<VisitlogDto> result = VisitlogDao.getInstance().vread();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		System.out.println(jsonArray);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	
		
		}

	// 3. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. AJAX 데이터 요청
		// 2. 데이터가 많으면 객체화
		// 3. 다오에게 전달 후 SQL 결과를 받는다
		// 4. 결과를 AJAX 에게 전달 한다
		
		
		
		// 1. request.getParameter("속성명")
		int vno = Integer.parseInt(request.getParameter("vno")); System.out.println(vno);
		String vcontent = request.getParameter("vcontent"); System.out.println(vcontent);
		String vpwd = request.getParameter("vpwd");System.out.println(vpwd);
		
		boolean result = VisitlogDao.getInstance().vupdate(vno, vcontent, vpwd);
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		
		
		
	}

	// 4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int vno = Integer.parseInt(request.getParameter("vno"));
		String vpwd = request.getParameter("vpwd");
		
		boolean result = VisitlogDao.getInstance().vdelete(vno, vpwd);
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);

	}

	/* http 서블릿 클래스는 기본적으로 get , post , put , delete 함수 제공
		기본 톰캣 서버는 get , post 만 매개변수 전달 가능
	 	put , delete 는 서버마다 설정 해줘야됨 // 삭제하면 다시해
	 sever.xml -> source 63번째 줄 코드
	 <Connector connectionTimeout="20000" maxParameterCount="1000" port="80" protocol="HTTP/1.1" redirectPort="8443"/>
	 수정할거
	 <Connector connectionTimeout="20000" port="80" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="POST,PUT,DELETE" URIEncoding="UTF-8"/>
	 */


}//class
