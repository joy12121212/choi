package 복습.part5;

import java.util.Iterator;
import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		
		Member[] membeList = new Member[100];
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("----------회원 시스템-----------");
			System.out.println("1.회원가입 2.로그인    선택>");
			int sc = scanner.nextInt();
			
			if (sc == 1) {
				System.out.println("아이디 : "); String mId = scanner.next();
				System.out.println("비밀번호 : "); String mPw= scanner.next();
				System.out.println("이름 : "); String mName = scanner.next();
				System.out.println("핸드폰번호 : "); String mPhone = scanner.next();
				System.out.println("나이 : "); int mAge = scanner.nextInt();
				
				
			Member member = new Member();
			
			member.id = mId; member.pw = mPw; member.name = mName; member.phone = mPhone; member.age = mAge;  
				
			for (int i = 0; i < membeList.length; i++) {
				if (membeList[i]==null) {
					membeList[i]=member;
					break;
				}
			}
			
			}// if
			else if (sc == 2) {
				System.out.println("아이디 : "); String lId = scanner.next();
				System.out.println("비밀번호 : "); String lPw = scanner.next();
				
			int login = -1;
				for (int i = 0; i < membeList.length; i++) {
					if (membeList[i] != null && membeList[i].id.equals(lId) && membeList[i].pw.equals(lPw) ) {
						login = 0;
					}
				}
				if (login == 0) {
					System.out.println("로그인 성공");
				}else {
					System.out.println("로그인 실패");
				}
				

				
			}//else
			
			
			
			
		}//while
		
		
		
	}//main

}//class
