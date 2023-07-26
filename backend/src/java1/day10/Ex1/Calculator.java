package java1.day10.Ex1;
// 231 ~ 232
public class Calculator { 
	// 설계도 목적
	
	// class 기준으로 내부, 외부 구분 된다.
	
	// 1. 필드
	
	// 2. 생성자
	
	// 3. 메소드 : 객체의 동작 [ * 객체간의 상호작용 ]
		
		//1. 리턴타입 : 메소드 실행한 후 호출했던 곳으로 전달하는 값의 자료형
		//2. 메소드명 : 소문자 시작, 카멜 사용
		//3. 매개변수 : 메소드 호출 할때 전달할 매개값
		//4. { }	: 메소드 호출시 실행되는 구역
	
	
		// 1. 리턴이 없는 메소드 // 리턴 x 매개변수 x // 단순 실행용
	void powerOn() {	
		System.out.println("전원을 켭니다.");
	}
		//2. 리턴이 없는 메소드 // 리턴 x 매개변수 x // 단순 실행용 
	void powerOff() {
		System.out.println("전원 끔");
	}
	
	int plus( int x , int y ) {// 3. 매개변수 O , 호출한 곳으로 int 를 리턴하는 메소드
		// vod를 제외한 리턴타입이 있을경우 return 키워드 필수 // 없으면 오류 뜸
		int result = x + y; // 입력받은 x , y 를 활용, 결과값을 만든다
		return result; // 결과값을 호출한곳에 되돌려 준다
	}
	
	double divide ( int x , int y ) {// 4. 매개변수 O , 호출한 곳으로 int 를 리턴하는 메소드
		double result = (double)x / (double)y;
		return result;
	}

	
}//class


