package java1.day20.Ex1;

public interface RemoteControl {// 인터페이스 선언
	// 인터페이스 : 두 장채 를 연결하는 접속시
	// 구성멤버
		// 1. public 상수 필드			// 변하지 않는 절대값 = 상수 = 다 같이 쓴다 [ public static final 이 생략되어 있음 ]
			
			int MAX_VOLUME = 10;
			public static final int MIN_VOLUME = 0;
	
		// 2. public 추상 메소드		// [public abstract 생략 되어 있음]  // 선언부 // 선언만 가능하다
			
			void turnOn();
			public abstract void turnOff();
			void setVolume( int volume);
			
		// 3. public 디폴트 메소드	[public 생략 가능]	선언부 + 실행부 까지
			
			default void setMute(boolean mute) {
				
				if (mute) {
					System.out.println("무음 처리 한다");setVolume(MIN_VOLUME);
				}else {
					System.out.println("무음을 해제 한다"); 
				}
			}
			
			public default void getMute() {System.out.println();}
			// 얘는 무조건 dafault 넣어야된다
			
		// 4. public 정적 메소드	[pulic 생략 가능]
			
			static void changeBattery() {System.out.println("빠떼리를 교체 했다구");}
			public static void checkBattery() {System.out.println("약 있냐");}
			
			
			
			
			// 5번 6번 얘네는 자바 9 이상 버전부터 지원 된다
			
		// 5. private 메소드		: 디폴트 메소드 안에서만 호출 가능
			
			//private void defaultCommon() {System.out.println("디폴트 메소드");}
			
		// 6. private 정적 메소드	: 디폴트메소드,정적 메소드 호출 가능
			
			//private static void staticCommon() {System.out.println("정적 메소드");}
			
			
			

}// 인터페이스


/*
	인스턴스 멤버	: 객체 생성시 메모리 할당되어 사용 가능 / 필드 , 메소드			[ static 없다 ]
	정적 멤버		: 객체가 없어도 메모리 우선 할당되어 바로 사용 가능 / 필드 , 메소드	[ static 있다 ]
		- 정적 멤버는 인스턴스 멤버에 접근할 수 없다 [p.249]








*/