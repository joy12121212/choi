package java1.day18.Ex1;

public class Ex1_실행 {
	public static void main(String[] args) {
		
		// 인터페이스 탐입의 변수 선언
		RemoteControl rs;
		
		// 인터페이스 변수에 Television 객체 대입
		rs = new Television();
		// rs - > 구현객체 // 추상 메소드가 존재하는 인터페이스를 구현 한 클래스 // 클래스에서 코드치고 그걸 객체로 만들면 구현객체
		
		// turnOn(); 메소드 실행
		rs.turnOn();
		
		// audio 객체로 바꿈
		rs = new Audio();
		
		rs.turnOn();

		
		
		System.out.println("리모컨의 최대 볼륨 : " + rs.MAX_VOLUME);
		System.out.println("리모컨의 소 볼륨 : " + rs.MIN_VOLUME);
		
		
		rs.setVolume(4);
		
		
		
		
		
		/*
		 
		 	인터페이스			vs			상속
		 	implemintes 				extends
		 	구현하다						연장하다
		 	여러개 구현 가능					1개만 상속
		 	추상메소드						메소드
		 	* 버전에 따라 다양한 메소드 제공 할 수 있음
		 	목적 : 메소드 통합				빠른 개발 / 모듈화[쪼갠다 = 유지보수 용이]
		 	
		 	예) 게임패드					예) 직급 
		 
	 
		 
		 
		*/
		
		
		
		
		
		
		
		
		
		
	}//main
}//class
