package java2.day23.Ex_2;

public class Ex2_멀티스레드Yield {
	public static void main(String[] args) {
		
		// 1. main 스레드 - 작업스레드A 객체 생성
		WorkThread workThreadA = new WorkThread("workThread A");
		// 1. main 스레드 - 작업스레드B 객체 생성
		WorkThread workThreadB = new WorkThread("workThread A");
		
		// 2. 작업스레드 A 실행
		workThreadA.start();
		// 2. 작업스레드 B 실행
		workThreadB.start();
		
		// 3. 5초 후 A스레드 잠시 일시 정지 시킨다 [ 양보 한다 ]
		
		try {Thread.sleep(5000);} catch (InterruptedException e) {}
		workThreadA.work = false;
		
		// 4. 메인스레드가 10초 후에 다시 실행 [ 양보 취소 ]
		
		try {Thread.sleep(10000);} catch (InterruptedException e) {}	
		workThreadA.work=true;
	}

}
