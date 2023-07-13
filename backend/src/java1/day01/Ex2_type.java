package java1.day01; // 현재 클래스 패키지 경로

public class Ex2_type {//class 시작
	public static void main(String[] args) {//main 시작
	
		// 1. 진수를 표현하는 방법
			// 진수 : 데이터를 표현하는 수의 형식 // 기계어[2진수/이진코드] 표현의 한계를 극복하기 위해 16진수 사용
			// 0~1 : 2진수 , 0~7: 8진수 , 0~9 : 10진수 , 0~9(a)10(b)11(c)12(d)13(e)14(f)15 : 16진수 
		
		int val = 0b01011; // 데이터 앞에 0b를 사용하면 2진수를 표현
			System.out.println(val);
		int val1 = 0206; // 데이터 앞에 0을 사용하면 8진수를 표현
			System.out.println(val1);
		int val2 = 365; // 10진수는 평소처럼 사용
			System.out.println(val2);
		int val3 = 0xb3; // 데이터 앞에 0x를 사용하면 16진수
			System.out.println(val3);

		//byte = -128 ~ 127까지 저장 가능
		byte b1 = -128; 
			System.out.println(b1);
		byte b2 = 127; 
			System.out.println(b2);
		//byte b3 = 200; // 오류 /용량 초과
			
		// short = -32,768 ~ 32,767
		short s1 = 32000;
			System.out.println(s1);
		// short s2 = 33000; // 오류 /용량 초과

		//int = +-21억 // 기본 자료형 // 개발자가 입력한 정수는 기본값이 int 이다
		int i1 = 2100000000;
			System.out.println(i1);
		//int i2 = 2200000000;// 오류 /용량 초과
		
		// long = 1000경 까지 출력 .. 21억 넘어가면 long // 1000경을 넘으면 문자 처리 해
		long l3 = 10000000000L;	// 마지막에 l 적어줘야 long 으로 인식 / 안적으면 int로 인식 = 오류
			System.out.println(l3);
			
		// 문자
		char c1 = 'a';
			System.out.println(c1);
		char c2 = 65;
			System.out.println(c2);
		char c3 = '가';
			System.out.println(c3);
		char c4 = 44032;
			System.out.println(c4);
		
		// String class [ 문자열 저장 ] 	
		String st1 = "안녕하세요";
			System.out.println(st1);
		
		// float , double(실수 기본 타입)	
		float f1 = 0.1234567f;
			System.out.println(f1);			
		double d1 = 0.1234567891234567;	
			System.out.println(d1);			
			
		// boolean = 0 false / 1 true
		boolean bool1 = true;
			System.out.println(bool1);
		boolean bool2 = false;
			System.out.println(bool2);

		// \" : "출력 , \' : '출력 , \\ : \출력 , \t : 들여쓰기 , \n : 줄 바꿈 , \r : 캐리지 린턴(커서 맨 앞으로)
			
	}//main 끝
}//class 끝


//	타입/자료형 : 메모리의 효율성, 가독성 높음
//		js : let , const
//		java : 정수형 byte , short , int, long // 문자 char // 논리 boolean // 실수 float(소수점8) , double(소수점17) // 문자열 String
//
//	용량 단위 : 8bit -> 1byte -> 1024byte -> 1kb -> 1024kb -> 1mb -> 1024mb -> 1gb 
//	기능처리 최소단위 : 비트
//	저장 최소단위 : 바이트
//	
//	인코딩 : 2진수를 문자로 표현하는 방법을 정의 했다
//	컴퓨터 : 0101010 --> 사람이 알아볼 수 있게 변환(규칙/패턴/해독 = 인코당) -> 사람이 알아봄
//	아스키코드 : 7비트(확장 8비트) -> 128문자 표현 가능
//	유니코드 : java - utf-8 // 전세계 공용어 문자 표현할 수 있는 산업 표준






