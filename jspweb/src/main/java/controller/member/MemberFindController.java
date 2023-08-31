package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;

@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberFindController() {
        super();
        // TODO Auto-generated constructor stub
    }
    	// 메소드 하나에 ajax 여러개 쓰려면 type 정송
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		
		String type = request.getParameter("type"); 
		String data = request.getParameter("data");
		
		// 객체화 / 유효성 검사
		// 다오 요청 결과
		boolean result = MemberDao.getInstance().findIdOrEmail(type , data);		
		// 결과 전달
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 매개변수 요청
		String mid=request.getParameter("mid"); System.out.println("로그인세선 가져온 id " + mid);
		String mpwd = request.getParameter("mpwd");System.out.println("로그인세선 가져온 pw " + mpwd);
		System.out.println(mid + mpwd);
		
		
		// 2. 객체화 유효성 검사
		
		// 3. dao 에게 전달 후 결과 받기
		boolean result = MemberDao.getInstance().login(mid, mpwd);
		
		if (result == true) {
			
			MemberDto loginDto = MemberDao.getInstance().info(mid);
			//세션에 저장한다
			request.getSession().setAttribute("loginDto", loginDto);
			MemberDto dto = (MemberDto)request.getSession().getAttribute("loginDto");
			System.out.println("세션상태 : "+dto);
		}
		
				
		// 4. 결과 응답
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
	}

}


/*

	- 저장소
		1. java/js 메모리
			- java 종료되거나 js 종료되면 사라짐(휘발성)
			- dto 이동객체, 로직 필요한 변수들 ( 생성 조건에 따라 사용 범위가 다르다 )
			
			세션(객체) ( static ) : 모든 곳에서 동일한 메모리 사용
				- 장점 : 모든곳에서 사용 가능함
				- 단점 : 프로그램/서버 가 종료될때까지 유지 = 메모리 많이 사용 함
				- 로그인 정보 : 페이지가 전환 되더라도 로그인 상태는 유지되어야 하기 때문에
				- 
			
		2. DB 메모리
			- 영구저장 [ 논리구조(관계형[테이블/표]) 저장 ]
			- 회원정보, 게시판정보, 제품정보 등
			- 실제 데이터
		3. 파일처리
			- 영구저장 [ 문자열 저장 ]
			- log [ 예외처리 오류 정보, 최상위 보안 자료 ]
			- 실제 데이터
		4. 세션 / 쿠키
		
		
		
		
	
	로그인 했다는 증거 = > 인증 [ 인증서 -> 세션 저장 ]
		js : sessionStorage
			sessionStorage.setItem(키, 데이터)	: 저장
			sessionStorage.getItem(키)			: 호출
			
		
		java(서블릿,컨트롤러) :
		 		request.setSession().setAttribute("속성명" , 데이터 );		: 저장
		 		request.setSession().getAttribute("속성명");				: 호출
	
	서블릿
		내장객체
			request	: 요청
				request.getParameter()						: ajax로 부터 전달된 데이터 요청
				request.getSerbletContext().getRealPath();	: 서블릿 저장소의 실체 경로 검색
				request.getSession()						: 서버내 세션 객체 호출
				
			response : 응답
				response.getWriter().print();	: ajax에게 전달할 데이터 응답
				response.setContentType("application/json;charsetUTF-8);




*/













