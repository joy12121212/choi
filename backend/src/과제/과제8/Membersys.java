package 과제.과제8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

//목적 : 실행
public class Membersys {
	public static void main(String[] args) {
	
		// 0. 여러개 Member 객체 100개를 저장 예정인 배열 선언
		Member[] memberList = new Member[100];
		// 배열 선언 : 타입명[] 배열명 = new 타입명[길이];	
	
		
		while (true) {
			
			// 1. 무한 출력
			System.out.println("------회원시스템-------");
			System.out.println("1.회원가입 2.로그인		>선택");
			// 2. 무한 입력
			Scanner scanner = new Scanner(System.in);
			int sc1 = scanner.nextInt();
			
			System.out.println(Arrays.toString(memberList));
			
			// 3. 입력/선택 경우의 수
			if (sc1 == 1) {
				System.out.println("----------회원가입-----------");
				System.out.print("아이디 : "); 	String scId = scanner.next();
				System.out.print("비밀번호 : "); 	String scPw = scanner.next();
				System.out.print("이름 : "); 	String scNm = scanner.next();
				System.out.print("전화번호 : "); 	String scPn = scanner.next();
				System.out.print("나이 : "); 	int scAge = scanner.nextInt();
				// 2. 5가지를 하나로 묶음 = 문자열 vs 객체
				// * 객체 선언 : 클래스명 객체변수명 = new 생성자명();
				Member member = new Member(); // 필드에 기본값 들어가 있음
				//객체 내 필드 데이터 수정
				// .도트연산자 : 접근연산자 ( 스택 변수가 알고 있는 객체 주소로 이동!접근!실행!)
				
				member.id = scId; member.pwd = scPw; member.name = scNm; member.phone = scPn; member.age = scAge;
				//3. 여러개의 객체를 저장하기위해 배열에 저장
					//*이어있는 인덱스=기본값인데스를 찾아서 해당 인덱스에 객체 저장
				for (int i = 0; i < memberList.length; i++) {
					if (memberList[i]==null) { // i번째 인덱스가 null 이라면 입력받아 만든 객체를 대입 한다
						memberList[i]=member;
						break;
					}
					
				}
				
				
				
			}else if (sc1 == 2) {
				System.out.println("-----------로그인-----------");
				System.out.print("아이디 : "); 	String scId = scanner.next();
				System.out.print("비밀번호 : "); 	String scPw = scanner.next();
				
				int login = -1; // ★로그인 여부를 저장하는 변수 // -1은 못 찾았다 0 이상이면 찾고 찾은 인덱스번호 저장
				
				// 2. 입력받은 데이터 배열에 찾기
				for (int i = 0; i < memberList.length; i++) {
					// 멤버리스트가 비어있지(null) 않고 , 멤버리스트의 i 번째 id 와 pwd 와 같으면 로그인 성공
					// null 이 있으면 컴퓨터가 뭘 확인하라는건데 ? 라며 오류가 발생 한다
					// 그래서 memberList[i] != null  -> null은 건너 뛰라고 해야 한다
					if (memberList[i] != null && memberList[i].id.equals(scId) && memberList[i].pwd.equals(scPw)) {
						login = 0;//로그인 성공 후 변수에 성공한 인덱스 저장 = 추후에 로그인 상태 활용
						break;
					}
				}//for
				
				if (login >= 0) {
					System.out.println("로그인 성공"); // 추후에 로그인시 새로운 메뉴 메소드 호출
				}else {
					System.out.println("로그인 실패");
				}
				
			} 
			
			
			
		}//while
		
				
	}//main
}//class



/*


	주제 : 회원제 시스템
		0. 저장
			아이디 , 비밀번호 , 이름 , 전화번호
			* 4가지 필드 / 변수 / 데이터 를 하나의 묶음 방법
			--> 문자열 이용 : "아이디,비밀번호,이름,전화번호"	: 쉼표 이용한 필드 구분
			--> 클래스(필드) 이용
				1. 클래스 설계 = 새로운 클래스.java 파일 생성
				2. 클래스 멤버 구성 : 필드, 생성자, 메소드
			* 하나로 묶인 (기존동일=타입동일) 여러개 저장 방법은?
			--> 문자열 배열 : String[] 문자열배열 = new String[100];		
			--> 문자열 배열 : Member[] 객체배열 = new Member[100];		
		1. 초기 메뉴
			1. 회원가입 2. 로그인

		2. 조건 기능
			1. 회원가입
				1. 아이디, 비밀번호, 이름, 전화번호 나이 각 입력받아 저장
				2. Member 객체화
				3. 객체를 배열에 저장
				
			2. 로그인
				1. 아이디, 비밀번호 입력받아 저장
				2. 배열내 입력받은 아이디, 비밀번호와 동일한 값을 찾기












*/