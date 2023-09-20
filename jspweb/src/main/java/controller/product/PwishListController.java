package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.ProductDao;
import model.dto.MemberDto;
import model.dto.ProductDto;

/**
 * Servlet implementation class PwishListController
 */
@WebServlet("/PwishListController")
public class PwishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PwishListController() {
        super();
    }

    // 찜하기 등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 찜하기 등록할 제품 번호
    	int pno = Integer.parseInt( request.getParameter("pno"));
    	System.out.println("찜하기"+pno);
    	// 서블릿은 로그인한 정보를 알고 있음 = mno - servletsessoin
    	// 리퀘스트 하고, memberDto로 형변환 하고, getmno 가져와서 mno에 대입
    	int mno = ((MemberDto) request.getSession().getAttribute("loginDto")).getMno();
    	
    	// 다오에게 보내야됨
    	boolean result= ProductDao.getInstance().setWish(mno, pno);
    	
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
    	
    	
    }
    
    // 찜하기 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if(type.equals("findByWish")) {
			
			int pno = Integer.parseInt(request.getParameter("pno"));
			
			int mno = ((MemberDto) request.getSession().getAttribute("loginDto")).getMno();
			
			boolean result = ProductDao.getInstance().getWish(mno, pno);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(result);		
		}else if (type.equals("findByAll")) {
			int mno = ((MemberDto) request.getSession().getAttribute("loginDto")).getMno();
			List<ProductDto> reslut = ProductDao.getInstance().getWishProductList(mno);
			ObjectMapper objectMapper = new ObjectMapper();
			String JsonArray = objectMapper.writeValueAsString(reslut);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(JsonArray);					
			
		}
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
