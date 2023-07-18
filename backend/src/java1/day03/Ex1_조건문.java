package java1.day03;

import java.util.Random;

public class Ex1_조건문 {
	public static void main(String[] args) {
		
		
		int score = 93;
		
		// 1. 
		if (score >= 90) System.out.println("합격1");
		// 2.
		if (score >= 96) 
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 a 등급 입니다.");
		
		// 2.
		if (score < 90) 
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 b등급 입니다.");
		 // 중괄호 묶어줘야 한다

		// 3.	
		if (score >= 90) {
			System.out.println("합격1");
		}else {
			System.out.println("땡~");
		}
		
		// 4.
		if (score >= 90) {
			System.out.println("4점수가 100~90입니다.");
			System.out.println("4등급은 a등급 입니다");
		}else if (score >= 80) {
			System.out.println("4점수가 80~89입니다.");
			System.out.println("4등급은 b등급 입니다");
		}else if (score >= 70) {
			System.out.println("4점수가 70~79입니다.");
			System.out.println("4등급은 c등급 입니다");
		} else {
			System.out.println("4점수가 70미만 입니다.");
			System.out.println("4등급은 d등급 입니다");
		}
		
		if (score >= 90) {
			System.out.println("4점수가 100~90입니다.");
			System.out.println("4등급은 a등급 입니다");
		}if (score >= 80) {
			System.out.println("4점수가 80~89입니다.");
			System.out.println("4등급은 b등급 입니다");
		}if (score >= 70) {
			System.out.println("4점수가 70~79입니다.");
			System.out.println("4등급은 c등급 입니다");
		}if (score < 70) {
			System.out.println("4점수가 70미만 입니다.");
			System.out.println("4등급은 d등급 입니다");
		}
		
		
		// 난수
		
		System.out.println(Math.random()); // 0.0 <= ~ < 1.0
		System.out.println(Math.random()*6); // 0.0 <= ~ < 6.0
		System.out.println((int)Math.random()*6); // 0 ~ <= 6
		System.out.println((int)Math.random()*6+1); // 1 ~ <= 7
		
		// 정수 난수 공식 : (int) (Math.random() * n ) + s
			// s : 난수 시작 번호 , n : 난수 개수
		System.out.println( (int) (Math.random()*45)+1);
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		// 난수 생성 클래스 : Random 클래스
			// 1. Random 객체 생성한다.
		Random random = new Random();
			// 2. 랜덤 값 호출
		System.out.println(random.nextInt());
		System.out.println(random.nextInt(3));
		// random.nextint(개수)+시작번호
		System.out.println(random.nextInt(6)+1); // 1에서 6까지 난수 생성 
		System.out.println(random.nextInt(45)+1); // 1에서 45까지 난수 생성
		//ㅇㅖ시) a-z
		System.out.println((char)random.nextInt(26)+97); // 97~122 까지 난수 생성
		
		int num = (int) (Math.random()*6) + 1;
		
		if (num==1) {
			System.out.println("1번이 나왔습니다.");
		}else if(num==2){
			System.out.println("2번이 나왔습니다");
		}else if(num==3){
			System.out.println("3번이 나왔습니다");
		}else if(num==4){
			System.out.println("4번이 나왔습니다");
		}else if(num==5){
			System.out.println("5번이 나왔습니다");
		}else {
			System.out.println("6번이 나왔습니다");
		}
		
		
		
		// if 중첩
		int score3 = (int)(Math.random() * 20)+81;

		String grade; //등급 저장하는 변수
		
		if (score3  >= 90) {
			
			if (score3 >= 95) {//95~100 , 95 이상이면
				grade = "A+";
			} else {
				grade = "A"; //그 이하면
			}
		}else {
			if (score3 >= 85) { // 85~89 , 85 이상이면
				grade = "B+";
			}else {
				grade = "B"; // 그 이하면
			}
		}System.out.println(grade);
		
		
		switch (2) {
			case 1 : System.out.println("1 나왔습니다"); break;
			case 2 : System.out.println("2 나왔습니다"); break;
			case 3 : System.out.println("3 나왔습니다"); break;
			case 4 : System.out.println("4 나왔습니다"); break;
			case 5 : System.out.println("5 나왔습니다"); break;
			default : System.out.println("6 나왔습니다");
		}
		
		
		// 121p
		
		char grade2 = 'B';
		
		switch (grade2) {
		case 'A':
		case 'a':System.out.println("A등급 우수 회원");
			break;
		case 'B':
		case 'b': System.out.println("b등급 회원");
			break;
		default: System.out.println("회원이 아님다");
		}
		
		
		
		
		
		
	}// main
}



/*

	if : 조건에 따른 흐름 제어
		형태
			1. if (조건식) 실행문;
			
			2. if (조건식) {실행문,실행문}
			
			3. if (조건식) {참일경우 실행문}
				else(거짓일경우 실행문}
			
			4. if (조건식) { 참일경우 실행문 }
				else if {참일경우 실행문}
				else if {참일경우 실행문}
				else if {참일경우 실행문}
				else{거짓일 경우 실행문}
			
			5. if 중첩
				if(){
					if(){}
				
				}else{
					if(){}
				}

	switch(변수) {
		case 1 : 
		case 2 :
		case 3 : 
		default : 
	}
	* if = 조건에 따른 true / false 실행
	* switch = 값이 정해져 있으면 빠름 // 비교연산 불가
		- break; : 해당 case 실행 후 멈춤/ 안하면 끝까지 돈다



*/