package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class MemberInfoController
 */
@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }
    //회원등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
    }
    
    
    
    //회원호출(세션호출) / 로그아웃(세션초기화)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 없음
		//객체화 없음
		//다오 없음
		//응답만
		
		String type = request.getParameter("type");
		
		if (type.equals("info")) {
			//세션에 저장된 로그인객체 꺼내기
			// 세션호출 타입은 object
		Object session = request.getSession().getAttribute("loginDto");
			// 타입변환[부모 -> 자식으로 객체타입변환(캐스팅)]
		MemberDto loginDto = (MemberDto)session;
		
			// Dto는 스크립트가 이해할 수 없는 언어-> 언어 변경 [jackson 라이브러리]
		ObjectMapper objectMapper = new ObjectMapper();
			// ObjectMapper 객체 만들고 objectMapper.writeValueAsString 이걸로 json에 대입
		String json = objectMapper.writeValueAsString(loginDto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(json);			
			
			
		}
		else if (type.equals("logout")){
			//세션에 저장된 로그인 객체 없애기, 초기화 
			// 방법1 : 모든 세션을 초기화하는 함수
//			request.getSession().invalidate(); // 로그인 뿐만 아니라 모두 삭제 됨 /장바구니, 오늘열어본 페이지 등
			// 방법2 : jvm 가비지컬렉터로 활용/아무것도 없다=값이 없다=null = 삭제 시킴 활용
				//삭제할 세션속성명을 동일하게 사용하여 null 대입
			request.getSession().setAttribute("loginDto", null);
		}
		
	}

	// 회원수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	 	//첨부파일 전송 했을때
    		// 1. 첨부파일 서버pc에 업로드 (cos 라이브러리)
		MultipartRequest multi = new MultipartRequest(
				request , 			// 요청 방식
				request.getServletContext().getRealPath("/member/img") ,// getRealPath 얘가 앞에 경로 다 찾아줌 / 첨부파일을 저장할 폴더 경로
				1024*1024*10,		// 첨부파일 용량 허용 범위 10MB
				"UTF-8",			// 한글 인코딩
				new DefaultFileRenamePolicy()	// 만약에 서버내 첨부파일중 동일한 이름이 있으면 뒤에 숫자 붙임
				);
		//----------------------파일업로드----------------//
		

		
		
		//-----------------------db업데이트--------------//
		String mimg = multi.getFilesystemName("mimg");	//form 사용할때는 name 꺼 가져와야 됨
		Object object = request.getSession().getAttribute("loginDto");
		MemberDto memberdto = (MemberDto)object;
		int loginDto = memberdto.getMno();
		System.out.println("회원수정 컨트롤러" + loginDto+" " +mimg );
		
		//만약에 수정할 첨부파일 없으면 // 기본거 넣어놔야됨
		if (mimg == null) {
			mimg = memberdto.getMimg();
		}
		
		
		boolean result = MemberDao.getInstance().mupdate(loginDto , mimg);
		
		response.setContentType("application/json;charset=UTF8");
		response.getWriter().print(result);
		
		
	}
	// 회원삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//입력받을 비밀번호 가져오기
		String mpwd = request.getParameter("mpwd");		System.out.println("컨트롤러 삭제 mpwd : " + mpwd);
		
		Object object = request.getSession().getAttribute("loginDto");
		MemberDto memberDto = (MemberDto)object;
		int loginDto = memberDto.getMno();
		System.out.println("컨트롤러 삭제 loginDto : " + loginDto);
		
		//한줄 줄이기 int loginMno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		
		
		boolean result = MemberDao.getInstance().mdelete(loginDto, mpwd);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);

	
	}

}
