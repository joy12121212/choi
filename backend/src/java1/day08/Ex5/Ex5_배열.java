package java1.day08.Ex5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Ex5_배열 {
	public static void main(String[] args) {
		
		String[] memberList = new String[100]; // 100개 문자열 저장 가능한 배열 선언
		
		
		while (true) {//무한루프
			
			System.out.println(Arrays.toString(memberList)); // test용 찍어보기 // memberList 안에 뭐가 있나..
			
			// 1. 무한입력
			System.out.println("1. 회원가입 : ");
			
			// 2. 무한입력
			Scanner scanner = new Scanner(System.in); // Scanner 라는 클래스를 활용 // scanner 라는 변수에 Scanner 클래스의 힙 영역 주소값을 대입 한다
			
			int sc = scanner.nextInt(); // scanner 변수에 nextInt 메소드 호출, 사용 후 sc 에 대입한다
			
			if (sc == 1) {
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("비밀번호 : "); String pw = scanner.next();
				// 1. 하나의 문자열로 합치기
				String member = id + "," + pw; // (아이디 , 비밀번호) // csv 로 필드 구분
				// 2. 배열내 비어 있는 인덱스 찾아서 대입
				for (int i = 0; i < memberList.length; i++) {
					if (null == memberList[i]) { // memberList i 번째 인덱스 값이 null 이라면
						memberList[i] = member; // member 값을 대입 한다
						break;
					}//if
				}//for
			}//if
			
			
			
			
			
			
		}//while
	}//main

}
