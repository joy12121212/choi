package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;


public class MainPage {
	
	// 객체 생성
	private static MainPage mainPage = new MainPage();
	
	// 외부 접근 메소드 생성
	public static MainPage getInstance () { return mainPage;}
	
	// 외부 객체 생성 제한
	private MainPage () {}

	
	private Scanner sc = new Scanner(System.in);
	
	
	
	// 1. 메인메뉴
	public void mainView() {
		
		while (true) {
			System.out.println("\n\n ==== 회원제 커뮤니티 =====");
			System.out.println("1. 회원가입 2. 로그인 선택 : ");
			
			try {
				int ch = sc.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException 오류 발생
				if (ch == 1) {signupView();}
				if (ch == 2) {loginView();}
			
			} catch (Exception e) {
				System.out.println("경고 - 숫자 똑바로 입력해라");
				sc = new Scanner(System.in); // 입력 객체의 메모리를 새롭게 만들어준다 그래야 무한로프 안돌고 처음으로 돌아간다
			}

		}
		
		
	}
		
	// 2. 회원가입
	public void signupView() {

		System.out.println("아이디 : "); String id = sc.next();
		System.out.println("비밀번호 : "); String pw = sc.next();
		System.out.println("이름 : "); String name = sc.next();
		System.out.println("전화번호[-]포함 : "); String phone = sc.next();
		//2. 입력받은 값을 컨트롤에게 전달하고 결과 받기
		boolean result =
		MemberController.getInstance().signupLogic(id , pw , name , phone);
		
		if (result) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
	}
	
	// 3. 로그인
	public void loginView() {
		
		System.out.println("아이디 : "); String id = sc.next();
		System.out.println("비밀번호 : "); String pw = sc.next();
		
		boolean resutl = 
		MemberController.getInstance().loginLogic (id , pw);
		
		if (resutl) {
			System.out.println("안내 - 로그인 성공");
		}else {
			System.out.println("안내 - 로그인 실패");
		}
		
		
	}
	
	
	
	
	
	
	
}

