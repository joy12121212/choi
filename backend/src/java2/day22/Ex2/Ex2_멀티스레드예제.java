package java2.day22.Ex2;

public class Ex2_멀티스레드예제 {
	public static void main(String[] args) {
		// 스레드 현황 : main - 싱글 스레드
		// 0 메인 스레드가 작업스레드 객체 생성
		// 1 메인 스레드가 1초마다 출력
		
		// 1. 메인 스레드가 작업스레드1 객체 생성
		작업스레드1 작업스레드1 = new 작업스레드1();
		Thread thread = new Thread(작업스레드1);
		thread.start();
		
		
		//2. 메인 스레드가 작업스레드2 객체 생성
		작업스레드2 작업스레드2 = new 작업스레드2();
		작업스레드2.start();
		
		// Thread.currentThread().getName()	: 이름 화인
		// Thread.currentThread().setName() : 이름 수정
		try {
			int i = 1;
		while (true) {

			Thread.sleep(1000); // 1초간 일시정지 - 예외처리 필수
			System.out.println(Thread.currentThread().getName() + "--- main 스레드 1초마다 출력중 " + i);
			i++;
			if (i == 10) {
				break;
			}
		}//try
		}catch(Exception e) {System.out.println(e);}
		
		
		
		
		
		
		
		
	}//main

}//class
