package java1.day18.Ex1;

// 인터페이스 선언
public interface RemoteControl {
	

	
	// public static final 이 생략 되어있음
	int MAX_VOLUME =10;
	public static final int MIN_VOLUME = 0;
	
	
	// 멤버 구성
		// 1. 추상 메소드	: 선언만 하고 {} 구현은 하지 않는다.
		// 2. 상수필드 // static final
	
	
	public abstract void turnOn();   // {} 없음 
	
	//public abstract  생략 가능
	void trunOff();
	
	
	void setVolume(int volume);
	

}


/*

	JVM 실행 메모리
	
	1. 메소드영역			2. 스택영역			3. 힙영역
	- 클래스정보			- 함수 {} 내 변수들		- 객체 (인스턴스)
	- 메소드									- 필드
	- static 정적 
	
	class 사람 {








*/