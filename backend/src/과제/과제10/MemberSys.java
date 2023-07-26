package 과제.과제10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import 과제.과제10.Member;

public class MemberSys {
	
	static Member[] memberList = new Member[100];
	static Scanner sc = new Scanner(System.in);

	Member member = new Member();
	public static void main(String[] args) {

			
	
			
			
		while(true) {

			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			int ch = sc.nextInt(); 
			
			if( ch == 1 ) { 회원가입 ();}
			else if( ch == 2 ) { 로그인 (); } 
			else if( ch == 3 ) { 아이디찾기 (); } 
			else if( ch == 4 ) { 비밀번호찾기 (); } 
			
		} // w e 
	}//main
	
	
	
	
	static void 회원가입 () { 
		Member member = new Member();
		
		System.out.print("아이디를 입력 하세요 : ");  String id = sc.next(); member.setId(id);
		System.out.print("비밀번호를 입력 하세요 : ");  String pw = sc.next(); member.setPassword(pw);
		System.out.print("이름을 입력 하세요 : ");  String name = sc.next(); member.setName(name);
		System.out.print("전화번호를 입력 하세요 : ");  String phone = sc.next(); member.setPhone(phone);
		System.out.print("나이 입력 하세요 : ");  int age = sc.nextInt(); member.setAge(age);
		
		System.out.println(member);
		
		for (int i = 0; i < memberList.length; i++) {
			if (memberList[i] == null) {
				memberList[i] = member;
				break;
			}//if
		} System.out.println(Arrays.toString(memberList));
	}// 회원가입 끝
	
	
	static void 로그인() {

		System.out.println("아이디를 입력 하세요"); String id = sc.next();
		System.out.println("비밀번호를 입력 하세요"); String pw = sc.next();

		int login = -1;

		for (int i = 0; i < memberList.length; i++) {
			if (memberList[i] != null && memberList[i].getId().equals(id) && memberList[i].getPassword().equals(pw)) {
				login = 0;
				break; }
		}if (login >= 0) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}

	}//로그인 끝
	
	static void 아이디찾기 () {
		
		int idOk = -1;
		System.out.println("아이디를 입력 하세요"); String id = sc.next();
		for (int j = 0; j < memberList.length; j++) {
			if (memberList[j] != null && memberList[j].getId().equals(id)) {
				idOk = 0;
				break;
				}//if
			}//for
			if (idOk >= 0) {
				System.out.println("아이디는 : " + id);
			} else {
				System.out.println("아이디가 없습니다");
			}

		
	} //아이디 끝
	
	
	static void 비밀번호찾기 () {
		
		int tmp = (int) (Math.random()*4999);

		int pwOk = -1;
		
		System.out.println("비밀번호를 입력 하세요"); String pw = sc.next();
	
		for (int k = 0; k < memberList.length; k++) {
			if (memberList[k] != null && memberList[k].getPassword().equals(pw)) {
				pwOk=0;
				break;
			}
			if (pwOk>=0) {
				System.out.println("임시비밀번호는 : "+tmp+" 입니다");
			}else {
				System.out.println("비밀번호 없음");
			}
			
		}
	}// 비밀번호 끝
	
}
/*

			3. 아이디찾기 메소드
				1. 이름 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 찾은 아이디 출력 
					- 아니면 없다.
					 
			4. 비밀번호찾기 메소드 
				1. 아이디 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 *임시 비밀번호(문자4자리 난수생성 ) 업데이트후 출력 
					- 아니면 없다.
*/














