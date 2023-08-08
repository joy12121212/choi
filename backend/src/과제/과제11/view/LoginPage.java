package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class LoginPage {
	
	// 싱글톤

	private static LoginPage loginPage = new LoginPage();
	//외부 접근 제한
	public static LoginPage getInstance() {return loginPage;};
	//외부 간접 접근
	private LoginPage() {};
	//외부 객체 생성 제한
	
	
	
	// 입력객체
	Scanner scanner = new Scanner(System.in);
	//1 loginMenu
	public void loginMenu() {
		
		while (MemberController.getInstance().getLoginSession() != 0) {
			
			System.out.println("\n\n ==== 회원제 커뮤니티 =====");
			System.out.println("1.로그아웃 2.회원정보 3.글쓰기 선택 : ");
			
			try {
				int ch = scanner.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException 오류 발생
				if (ch == 1) {MemberController.getInstance().logOut();}
				if (ch == 2) {info();}
				if (ch == 3) {boardWrite();}

			
			} catch (Exception e) {
				System.out.println("경고 - 숫자 똑바로 입력해라");
				scanner = new Scanner(System.in); // 입력 객체의 메모리를 새롭게 만들어준다 그래야 무한로프 안돌고 처음으로 돌아간다
			}
		
		}
		
		
	}
	//2 info	: 회원정보 페이지
	public void info() {

		System.out.println("\n\n ==== 회원정보 =====");
		// 1. 컨트롤에게 회원정보 요청해서 반환 받기
		MemberDto result = MemberController.getInstance().info();
		// 2. 반환받은 각각의 필드를 호출
		System.out.println("아이디 : " +result.getMid());
		System.out.println("이름 : " + result.getMname());
		System.out.println("연락처 : "+ result.getMphone() );
		
		
		//2. 서브메뉴
		
		System.out.println("1.비밀번호수정 2.회원탈퇴 3.뒤로가기 선택 : ");
		int ch = scanner.nextInt();
		if (ch == 1) {infoUpdate();}
		if (ch == 2) {infoDelete();}
		if (ch == 3) {return;}
	}
	
	
	
	
	
	//3 infoUpdate
	public void infoUpdate() {
		System.out.println("\n\n ==== 비밀번호변경 =====");
		System.out.println("새로운 비밀번호 입력 : ");
		String sc = scanner.next();
		
		boolean result = MemberController.getInstance().infoUpdate(sc);
		if (result) {
			System.out.println("비밀번호 수정 완료 로그아웃 합니다");
			MemberController.getInstance().logOut();
		}
		

	}	
	//4 infoDelete
	public void infoDelete() {
		
		System.out.println("\n\n ==== 회원탈퇴 =====");
		System.out.println("정말 탈퇴 함?? 1. 예 2. 아니오");
		int sc = scanner.nextInt();
		
		if (sc == 1) {
			boolean result = MemberController.getInstance().infoDelete();
			if (result) {
				System.out.println("회원탈퇴성공 : 로그아웃됩니다");
				MemberController.getInstance().logOut();
			}else {
				System.out.println("탈퇴실패 : 관리자 문의");
			}
		}
	
	}	
	
	//5 boardWrite
	public void boardWrite() {}	
	//6 boardPrint
	public void boardPrint() {}	
	//7 boardView
	public void boardView() {}	
	//8 boardUpdate
	public void boardUpdate() {}	
	//9 boardDelete
	public void boardDelete() {}	
}
