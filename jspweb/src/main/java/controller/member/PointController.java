package controller.member;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;
import model.dto.MpointDto;


@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PointController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // 포인트 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    	String mpno = UUID.randomUUID().toString(); // 16진법 32개 문자열(-까지 36) 식별 번호
    	System.out.println("mpno ? : "+mpno);
    	// 로그인 세션 mno
    	int mno =((MemberDto) request.getSession().getAttribute("loginDto")).getMno();
    	System.out.println("mno ? : "+mno);
    	// 3. 포인트 수량 , 지급 내역
    	long mpamount = Integer.parseInt(request.getParameter("mpamount"));
    	
    	String mpcomment= request.getParameter("mpcomment");
    	
    	MpointDto dto = new MpointDto(mpno,mno,mpamount,mpcomment,null);
    	
    	boolean result = MemberDao.getInstance().setPoint(dto);
    	
    	response.setContentType("application/json; charset=UTF-8");
    	response.getWriter().print(result);
    
    }
    
    //포인트 조회, 포인트 사용내역 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		int mno =((MemberDto) request.getSession().getAttribute("loginDto")).getMno();
				
		if(type.equals("pcheck")) {
			long result = MemberDao.getInstance().getPoint(mno);
			json = mapper.writeValueAsString(result);
		}else if (type.equals("plist")) {
			List<MpointDto> result = MemberDao.getInstance().getPointAll(mno);
			json = mapper.writeValueAsString(result);
		}		
		// 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(json);
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
