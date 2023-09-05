package controller.board;

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

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;
import model.dto.PageDto;

@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardInfoController() {
        super();

    }
    	// 쓰기
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// 첨부파일 업로드(있을경우)
    	MultipartRequest multi = new MultipartRequest(
    			request, 
    			request.getServletContext().getRealPath("board/upload"),	//저장경로
    			1020*1024*1024,		// 용량 1기가
    			"UTF-8",			// 인코딩 타입
    			new DefaultFileRenamePolicy() 
    			);
    	
    	System.out.println(request.getServletContext().getRealPath("board/upload"));
    	// 입력받은 매개변수 요청
    	
    	String btitle = multi.getParameter("btitle"); System.out.println(btitle);
    	String bcontent = multi.getParameter("bcontent");
    	String bfile = multi.getFilesystemName("bfile");
    	int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
    	int bcno = Integer.parseInt(multi.getParameter("bcno"));
    	
    	// 유효성검사/ 객체화
    	BoardDto boardDto = new BoardDto(btitle, bcontent , bfile , mno , bcno);
    	System.out.println(boardDto);
    	// 다오
    	boolean result = BoardDao.getInstance().bwrite(boardDto);
    	
    	// 다오 응답
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
    	
    	
    	
    }//doPost end
    
    	// 전체, 개별 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String type = request.getParameter("type");
	String json = "";
	ObjectMapper mapper = new ObjectMapper();
	
	if (type.equals("1")) {

		// 1. 카테고리별로 출력
		int bcno = Integer.parseInt(request.getParameter("bcno"));
		
		// 2. 출력할 게시물수, 하나의 페이지의 최대 게시물 수
		int listsize = Integer.parseInt(request.getParameter("listsize"));
		
		// 3. 페이지 처리
		int page = Integer.parseInt(request.getParameter("page"));
			// 1 . 페이지별 레코드의 시작번호
		int startrow = (page-1)*listsize;	// 페이지버호*최대게시물수
		
		// 4. 페이지 마지막 번호
			// 마지막페이지번호 / 총 페이지수 = 전체게시물수 / 페이지별 최대 게시물수(listsize)
		//전체게시물수
		int totalsize = BoardDao.getInstance().getTotalSize(bcno);
		System.out.println("토탈사이즈 " + totalsize);
		System.out.println("리스트사이즈 " + listsize);
		
		//전체페이지수
		int totalpage = totalsize%listsize == 0 ? totalsize/listsize : totalsize/listsize+1;
			// 게시물수 : 10 , 페이지별 2개씩 = > 총 5페이지[몫]
			// 게시물수 : 20 , 페이지별 3개씩 = > 총 6페이지[몫]+1
		System.out.println("토탈페이지 " + totalpage);
		
		//리스트 형식으로 반환 객체 만들기
		ArrayList<BoardDto> result = BoardDao.getInstance().blistAll(bcno,listsize,startrow);
		
		// pageDto 구성
		PageDto pageDto = new PageDto(page ,listsize ,startrow , totalsize , totalpage, result);
		
		json = mapper.writeValueAsString(pageDto);

	}else if (type.equals("2")) {
			// 개별 글 조회
		// 보낼 정보 객체화
		int bno = Integer.parseInt( request.getParameter("bno"));
		// 결과값 저장
		BoardDto result = BoardDao.getInstance().getBoard(bno);
			//만약에 요청자(로그인 or 비로그인)와 작성자가 동일 하면
				// 로그인 정보 [세션]
		Object object = request.getSession().getAttribute("loginDto");
		
		if(object == null) {//비로그인
			result.setIshost(false); // 다른 사람이 작성한 글
		}else {
			MemberDto login = (MemberDto)object;
			if (login.getMno() == result.getMno()) {result.setIshost(true);}
			else {result.setIshost(false);}
		}
		// 답장
		json = mapper.writeValueAsString(result);
	}
		//공통 로직 써서 코드 줄이기
	response.setContentType("application/json;charset=UTF-8");
	response.getWriter().print(json);
	}// doGet end
	
		// 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정할 첨부파일  업로드
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getServletContext().getRealPath("/board/upload"),
				1024*1024*1024,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
		// 수정할 데이터 객체화
		int bcno = Integer.parseInt(multi.getParameter("bcno"));
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		// 수정할 게시물 식별키
		int bno = Integer.parseInt(multi.getParameter("bno"));
		
		// 수정할 첨부파일 없으면 기존거 그대로 사용
		BoardDto boardDto = new BoardDto(bno,btitle,bcontent,bfile,bcno);
		if (boardDto.getBfile() == null) {
			boardDto.setBfile(BoardDao.getInstance().getBoard(bno).getBfile());
		}
		// dao
		boolean result = BoardDao.getInstance().onUpdate(boardDto);
		
		
		// 반환
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);		
	}// doPut end

		// 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bno = Integer.parseInt(request.getParameter("bno")); // bno 인트타입으로 보낼거라 형변환 필요//올때는 stirng이다
		System.out.println("컨트롤러 삭제 bno 확인 : " +bno);
		boolean result = BoardDao.getInstance().ondelete(bno);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	} // doDelete end

}
