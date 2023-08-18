package java2.day23.Ex_3;

public class Ex3_동기화 {
	public static void main(String[] args) {
		
		// 멀티스레드는 하나의 객체를 공유해서 작업할 수 있다
		
		//1. 계산기 객체 생성
		calculator calculator = new calculator();
				
		//2. 작업 스레드 유저1 객체 생성
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		user1Thread.start();
		
		//3. 작업 스레드 유저2 객체 생성

		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		user2Thread.start();
	
	}//main

}
