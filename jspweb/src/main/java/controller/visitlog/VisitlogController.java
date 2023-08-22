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

	}

	// 4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
