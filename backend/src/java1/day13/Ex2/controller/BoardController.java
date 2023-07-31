package java1.day13.Ex2.controller;

import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class BoardController {
	
	// 싱글톤 : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	
	// 1. 객체 생성
		private static BoardController boardController = new BoardController();
			
	// 2. 외부호출 생성
		public static BoardController getInstance() {return boardController;}
	
	// 3. 외부 객체 생성 금지
		private BoardController() {}
	
	
	
		// 글쓰기 처리 기능 함수 [ C ]
		public boolean writeLogic(String content , String writer) {
			// 1. 매개변수로부터 전달받은 content , writer 를 하나의 객체로 선언
			BoardDto boardDto = new BoardDto(content , writer);		
			BoardDao.getInstance().boardDtoList.add(boardDto);
			
			return true;
		}

		// 글출력 처리 기능 함수 [ R ]
		public BoardDto printLogic( int index) {
		
			// 조회수 증가
			if (index <= BoardDao.getInstance().boardDtoArray.length) {
			int view = BoardDao.getInstance().boardDtoList.get(index).getView();
			view++;
				BoardDao.getInstance().boardDtoList.get(index).setView(view);
			} // 조회수 증가 


			BoardDto boardDto = BoardDao.getInstance().boardDtoList.get(index);
			return boardDto;
		}

		// 글삭제 처리 기능 함수 [ U ] : 수정할 게시물 인덱스 , 수정할 내용 , 수정할 작성자
		public boolean updateLogic(int index , String content , String writer) {
			
			BoardDao.getInstance().boardDtoList.get(index).setContent(content);
			// 해당 리스트 인덱스에 content 값 setter 활용하여 수정 // 한번에 두개 못넣어서 두번에 나눠서 넣어줘야된다
			BoardDao.getInstance().boardDtoList.get(index).setWriter(writer);
			
			return true;	
		}

		// 글수정 처리 기능 함수 [ D ]
		public boolean deleteLogic(int index) {
			BoardDao.getInstance().boardDtoList.remove(index);
			// 해당 인덱스 번호 삭제
			System.out.println("테스트 4");
			return true;
		}
		
		
		
		
		
}//class