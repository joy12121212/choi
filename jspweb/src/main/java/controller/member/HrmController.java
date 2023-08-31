package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.HrmDao;
import model.dto.HrmDto;


@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HrmController() {
        super();

    }
    // 직원등록 // 첨부파일 있음
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uploadpath = request.getServletContext().getRealPath("/hrm/img");
    	
    	MultipartRequest multi = new MultipartRequest(
    			request, 
    			uploadpath,
    			1020*1024*10,
    			"UTF-8",
    			new DefaultFileRenamePolicy()
    			);
    	String sname = multi.getParameter("sname");  System.out.println(sname);
    	String sphone = multi.getParameter("sphone");System.out.println(sphone);
    	String sposition = multi.getParameter("sposition");System.out.println(sposition);
    	String simg = multi.getFilesystemName("smig");System.out.println(simg);
    	
    	//객체화
    	HrmDto hrmDto = new HrmDto(sname, sphone , sposition , simg);
    	//받기 아직 없음
    	boolean result = HrmDao.getInstance().signup(hrmDto);

    	
    	response.setContentType("application/json; charset=UTF-8");
    	response.getWriter().print(result);
    	
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//ArrayList<AccountBookDto> result = AccountBookDao.getInstance().acbRead();
		ArrayList<HrmDto> result = HrmDao.getInstance().sRead();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonArray);
		
		
	
	}
	
	

	
	
	
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
