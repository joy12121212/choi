package controller2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model2.dao.AccountBookDao;
import model2.dto.AccountBookDto;


@WebServlet("/AccountBookController")
public class AccountBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccountBookController() {
        super();

    }
    // 등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 아작스로 정보 가져오기
    	System.out.println("doPost 실행 되나요" );
    	String content = request.getParameter("content");
    	System.out.println(content);
    	int money = Integer.parseInt(request.getParameter("money"));
    	System.out.println(money);
    	String date = request.getParameter("date");
    	System.out.println(date);
    	
    	// 객체화 
    	
    	AccountBookDto accountBookDto = new AccountBookDto(content , money , date);
    	System.out.println(accountBookDto);
    	
    	boolean result = AccountBookDao.getInstance().acbWrite(content, money, date);
    	
    	response.setContentType("application/json; charset=UTF-8");
    	response.getWriter().print(result);
    	
    }// 등록 끝
    
    // 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget 실행 되나요");
		ArrayList<AccountBookDto> result = AccountBookDao.getInstance().acbRead();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonArray);
		
	} // 출력 끝
	
	// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doput 돌아가나");
		int ano = Integer.parseInt(request.getParameter("ano"));
		String content = request.getParameter("content");
		System.out.println(ano + content);
		boolean result = AccountBookDao.getInstance().acbUpdate(ano , content);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		
	}// 수정 끝

	// 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		boolean result = AccountBookDao.getInstance().acbDelete(ano);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		
		
	}// 삭제 끝

}
