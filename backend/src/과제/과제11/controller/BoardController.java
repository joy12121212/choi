package 과제.과제11.controller;


import java.util.ArrayList;

import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.BoardDto;


public class BoardController {
	// 0.싱글톤 
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() { return boardController; }
	private BoardController() {}
	
	// 9. boardWrite : 게시물쓰기 페이지 
	public boolean boardWrite( String title , String content ) {
		// 1. 유효성검사 
		if( title.length() == 0 || title.length() > 50  ) { return false; }
		// 2. Dto [ 입력받은제목 , 입력받은내용 , 로그인된회원번호= MemberController 의 loginSession  ]
		BoardDto boardDto = new BoardDto( 
							title, content, 
							MemberController.getInstance().getLoginSession() );
		// 2. 글쓰기전용 생성자가 없을때
		// BoardDto boardDto2 = new BoardDto( 0, title, content, null , 0, MemberController.getInstance().getLoginSession(), null);
		// 3. DAO에게 전달후 결과 받아서 받은 결과 바로 반환
		return BoardDao.getInstance().boardWrite(boardDto);
	}
	// 10. boardPrint : 모든 게시물 출력 
	public ArrayList<BoardDto> boardPrint() {
		return BoardDao.getInstance().boardPrint();
	}
	// 11. boardView : 개별 게시물 출력 
	public BoardDto boardView( int bno ) {
		return BoardDao.getInstance().boardView(bno);
	}
	
	
	// 12. boardUpdate : 게시물 수정 
	// [ 준비물 :
	//	bno = 수정할 게시물의 식별[누구를 수정할건지]
	//	mno = 작성자와 일치할경우에만 수정 가능[유효성검사]
	//	title = 수정할거
	//	content = 수정할거
	public int boardUpdate(int bno , int mno , String title , String content) {
		
		//1. 유효성 검사
			//2 . 게시물의 작성자 회원번호와 로그인된 회원과일치 하지 않으면
		if (mno != MemberController.getInstance().getLoginSession()) {return 3;	}
			//3 . 제목 글자수 체크
		if (title.length() < 1 || title.length() >50) {	return 4;}
		
		boolean result = BoardDao.getInstance().boardUpdate(new BoardDto(bno , title , content));
		if (result) {return 1;}
		else return 2;
	}
	// 13. boardDelete : 게시물 삭제
	public int boardDelete(int bno , int mno) {
		if (mno != MemberController.getInstance().getLoginSession()) {return 3;	}
		//3 . 제목 글자수 체크
	
	boolean result = BoardDao.getInstance().boardDelete(bno);
	if (result) {return 1;}
	else return 2;
	}


}




















