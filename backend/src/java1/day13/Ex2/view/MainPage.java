package java1.day13.Ex2.view;

import java.util.Scanner;

import java1.day13.Ex2.controller.BoardController;
import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class MainPage {
	// 싱글톤 : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행

	//------------------------싱글톤----------------------------------//
	
	// 1. 객체 생성
	private static MainPage mainPage = new MainPage(); 
	// 2. 외부 호출 생성
	public static MainPage getInstance() {return mainPage;}
	// 3. 외부 객체 생성 차단
	private MainPage() {}
	
	//-----------------------------------------------------------------//
	
	//메인 페이지 입출력 함수
	
	private Scanner scanner = new Scanner(System.in);
	
	
	public void mainPage() {
		
		while (true) {
			System.out.println("저장확인" + BoardDao.getInstance().boardDtoList);
			System.out.println("\n\n >>>>> 방문록 프로그램 >>>>>>");
			System.out.println("1.글등록 2.글보기 3.글수정 4.글삭제 선택>");
			
			int sc = scanner.nextInt();
			
			if (sc == 1) {	writeView(); }
			if (sc == 2) {  printView(); }
			if (sc == 3) {	updateView(); }
			if (sc == 4) {	deleteView(); }
			
		}
	}//mianPage
	
	
	// 글등록 페이지 입출력 함수
	
	public void writeView() {
		
		//1. 내용과 작성자을 입력받아 변수에 저장
		scanner.nextLine();  // nextLine() 함수 실행전 nextInt() 실행 되므로 오류 발생 방지!! // 그냥 하나 박아라
		System.out.print("방문록 : "); String content = scanner.nextLine(); // nextLine() 함수 앞뒤로 다른 next 가 있을대 하나의 입력으로 인식함
		System.out.print("작성자 : "); String writer = scanner.next();
		//2. 입력받은 변수를 컨트롤러에게 전달
		// 현재위치도 java 컨트롤도 java 이므로 메소드 이용한다.
		// 전달 = 매개변수 / 전달 받을때는 리턴으로
		boolean result = BoardController.getInstance().writeLogic(content , writer);
		//문자열 매개변수 1개를 전달하고 메소드 종료 후 boolean 타입으로 리턴 받음

		
		//컨트롤에게 전달받은 내용 제어 하기
		if (result) {
			System.out.println("글등록 성공");
		}else {
			System.out.println("글등록 실패");
		}
	}
	
	// 글출력 페이지 입출력 함수
	
	public void printView() { // 인덱스번호 알고있다고 가정함
		
		System.out.println("안내]출력할 게시물의 인덱스 : "); 
		int index = scanner.nextInt();
		
		// view 에서 컨트롤러에게 인덱스값 전달하고 게시물 1개 리턴 받음
		BoardDto result = BoardController.getInstance().printLogic(index);
		
		// 전달 받은 결과를 출력
		System.out.println("검색한 방문록 정보 " );
		System.out.println("작성자 : " + result.getWriter()
							+ " 내용 : " + result.getContent());
	}

	// 글수정 페이지 입출력 함수 

	public void updateView() { // 수정할 인덱스와 수정할 내용
		

		System.out.println("인덱스 번호 : ");
		int index = scanner.nextInt();
		System.out.println("수정할 내용 : ");
		scanner.nextLine();//오류 방지
		String content = scanner.nextLine();
		System.out.println("작성자 이름 : ");
		String writer = scanner.next();
		
		boolean result =  BoardController.getInstance().updateLogic(index , content , writer);
		if (result) {System.out.println("안내- 수정 성공");
		}else {
			System.out.println("안내 - 수정 실패");
		}
	}

	// 글삭제 페이지 입출력 함수
	
	public void deleteView() {
		//1. 삭제하는 게시물의 인덱스 입력 받아서 삭제
		System.out.println("삭제할 게시물 인덱스 : ");
		int index = scanner.nextInt();
		//2. view 에서 컨트롤에게 입력받은 인덱스 전달하고 삭제결과 여부 리턴 받음
		boolean result = BoardController.getInstance().deleteLogic(index);
		
		//결과값으로 제어
		if (result) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}

	}
	
}
