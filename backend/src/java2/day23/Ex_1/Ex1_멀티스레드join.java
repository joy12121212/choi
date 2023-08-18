package java2.day23.Ex_1;

public class Ex1_멀티스레드join {
	public static void main(String[] args) {
		// main 스레드가 main 함수를 호출 // 메인스레드는 눈에는 보이지 않는당
		
		System.out.println("현재 스레드 이름 : " +Thread.currentThread().getName());
		
		// 1. 스레드 객체 생성 [ 메인 외 추가적으로 작업스레드 생성 ]
		SumThread sumThread = new SumThread();
		// 2. 스레드 실행 => 대기상태 => cpu 스케쥴링 => 실행 => 대기상태 => 대기 => 실행
		sumThread.start();
		
		// 3. 작업 스레드 객체의 필드 확인
		// 메이스레드에서 프린트 찍는게 for 문이 100까지 도는거보다 더 빠름//그래서 결과값이 0으로 나온다
		//System.out.println(" 1~ 100 의 합 : " + sumThread.getSum());
		
		try {
			sumThread.join(); // join 때문에 sumThread.start(); 이거 다 돌때까지 메인스레드 멈춤, 다 끝나면 밑에 프린트 찍음
		} catch (Exception e) {}
		System.out.println(" 1~ 100 의 합 : " + sumThread.getSum());

	}// main

}// class


/*

	함수 호출 방법
		1. 인스턴스 함수
			클래스명 객체명 = new 생성자명();
				객체명.함수명();
				
		2. 정적 함수
			클래스명.함수명();
			
		3. 싱글톤
			클래스명.겟인스턴스.메소드명();
			
		4. main 함수 ... 예? 안보이는곳에서 메인스레드가 알아서 돌린다











*/