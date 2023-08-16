package java2.day21;

public class Ex1_예외처리 {
	
	public static void printLength(String data) {
		
		try {
			int result = data.length();		// ThisIsJava -> 스트링 값 정확히 대입 함 / null - > 아무것도 없음 -> 오류
			System.out.println("문자수 : " + result);
		}catch(NullPointerException e) {		// NullPointerException: 떴으니까 이걸 경험으로 넣는다
			System.out.println(e.getMessage());
			System.out.println(e);		//java.lang.NullPointerException: Cannot invoke "String.length()" because "data" is null
										// 오류 정보를 파일처리해서 문제 발생한 것들을 개발자가 업데이트/유지보수 진행
		}finally {//무조건 실행
			System.out.println("마무리 실행");
		}

	}// printLength
	
	
	public static void main(String[] args) {
		
		// p 466 실행 예외 [ 실행 후 예외가 발생하기에 경험, 테스트로 진행 ]
		
		System.out.println("프로그램 시작");
		printLength("ThisIsJava");
		printLength(null);
		System.out.println("프로그램 종료");
		
		
		//p 468 일반예외 [ 실행 전부터 컴파일러가 예외검사를 하기 때문에 빨간줄이 뜬다 ]
		try { // 예외가 발생할 것 같은 코드 + 예외가 무조건 발생하는 코드
		Class.forName("java.lang.String");		// Class.forName : 클래스 찾기 // java.lang.String
		System.out.println("여있네");
		// Unhandled exception type ClassNotFoundException : 클래스를 차지 못했을때 예외처리 미리 해라
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try { 
		Class.forName("java.lang.String2");	// 존재 하지않는 클래스므로 예외 발생 // catch 이동
		System.out.println("스트링2");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}// main

}//class


/*

	에러 : 컴퓨터의 하드웨어 고장으로 인해 실행 오류가 발생
	예외 : 에러 이외
		1. 일반예외 : 컴파일러가 예외 처리 코드 여부를 '검사하는' 예외
			- 외부 입출력 관련 : 파일처리 , JDBC (DAO) , 네트워크 , 입출력
			
		2. 실행예외 : 컴파일러가 예외 처리 코드 여부를 '검사하지 않는' 예외
			- 개발자의 경험에 의존해서 / 테스트
			- 타입 미스매치 , 배열 인덱스 , NULL
			
	예외처리
		try { 예외가 발생할것 같은 코드 }
		catch (예외 클래스 변수 객체) {예외가 발생했을때 실행할 코드}
		finally{예외와 상관없이 실행할 코드}

*/