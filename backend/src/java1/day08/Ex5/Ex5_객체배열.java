package java1.day08.Ex5;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5_객체배열 {

	public static void main(String[] args) {
		
			Member[] memberList = new Member[50];
		
		while (true) {
			
			System.out.println(Arrays.toString(memberList));
			
			System.out.println("회원가입 : ");
			Scanner scanner = new Scanner(System.in);
			int sc = scanner.nextInt();
			
			if (sc == 1) {
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("비밀번호 : "); String pw = scanner.next();

				// 1. 객체화 
				Member m = new Member(); // 객체 생성
				m.id = id; m.pw = pw; // 생성된 객체로부터 . 접근 연산자를 이용한 필드 수정
				//m 변수에 저장되어있는 Member 클래스의 id를 호출해서 스캐너로 입력받은 id 값을 대입 한다
	
				// 2. 배열에 저장
				
				for (int i = 0; i < memberList.length; i++) {
					if (memberList[i] == null) {// memberList 배열에 null 값이 있다면 m 에 대입된 데이터들을 대입
						memberList[i] = m;
						break;
					}// if
				}// for 
				
			} // if 
		}// w
		
		
	}// main
	
	
}//class
