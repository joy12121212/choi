package java1.day11.Ex4디자인패턴2.view;

import java.util.Scanner;

import java1.day11.Ex4디자인패턴2.controller.MemberController;
import java1.day11.Ex4디자인패턴2.model.dto.MemberDto;
import 과제.과제10.Member;

public class MainPage {
	//1. 필드
	//2. 생성자
	//3. 메소드
	
	private static MainPage mainPage = new MainPage();
	
	public static MainPage getInstance() {return mainPage;}
	
	private Scanner sc = new Scanner(System.in);
	
	public void mainPage() {

		
		while(true) {

			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");

			int ch = sc.nextInt(); 
			
			if( ch == 1 ) { }
			if( ch == 2 ) { } 
			if( ch == 3 ) { } 
			if( ch == 4 ) { } 

		} // w e 
	}

	void singupPage() {
		
		MemberDto memberDto = new MemberDto();
		
		System.out.print("아이디를 입력 하세요 : ");  String id = sc.next(); 
		System.out.print("비밀번호를 입력 하세요 : ");  String pw = sc.next(); 
		System.out.print("이름을 입력 하세요 : ");  String name = sc.next(); 
		System.out.print("전화번호를 입력 하세요 : ");  String phone = sc.next(); 
		System.out.print("나이 입력 하세요 : ");  int age = sc.nextInt(); 
		// 컨트롤러 에게 전달
		boolean result = MemberController.getInstance().singupLogic(id , pw , name , phone , age); //객체 가져오기 memberController  싱글톤 호출
		if (result) { System.out.println("획원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
	}
	void loginPage() {
		System.out.println("아이디를 입력 하세요"); String id = sc.next();
		System.out.println("비밀번호를 입력 하세요"); String pw = sc.next();
		boolean result = MemberController.getInstance().loginLogic(id , pw);
		if (result) { System.out.println("로그인 성공");
		}else {System.out.println("로그인 실패");}
	
		
		
	}
	void findIdPage() {}
	void fidePwPage() {}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
