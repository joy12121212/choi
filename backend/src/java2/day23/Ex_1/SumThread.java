package java2.day23.Ex_1;

public class SumThread extends Thread {

/* 
	멀티스레드 구현하는 방법
		1. Thread 클래스로붙 extends //필드 까지 오버라이드 할거면 상속이 좋지
		2. * Runnable 인터페이스로부터 implements // 메소드를 활용할거면 인터페이스가 활용도가 좋지
		
		- 상태
			1. new 이용한 스레드 객체 생성 [ 스레드 생성 ]
			2. start() 메소드 이용한 run() 작업코드 실행
				- start() 한다고해서 바로 실행x
				실행대기(Runnable) : 실행 대기상태[운영체제가 cpu 사용할 수 있게 해줄대까지 대기]=cpu스케쥴링
				실행 (Running)	: 해당 스레드의 순서가 되면 pu사용할 수 있는 권한 [ 명령어 전달]
				일시정지 : 스레드가 실행디기 가 아닌 잠시 정지된 상태
				종료 Terminated : 스레드 종료
				
				
				
		- 병렬(여러단위 흐름) 처리 vs 직렬(하나단위 흐름) 처리
		- 단일 스레드 : main 함수만 있는 경우
		- 멀티 스레드 : main 에서 thread 추가 하는 경우
		
		- 컴퓨터의 병렬 처리 방법
			-소프트웨어(손x, 논리) 자바는 직접적인 하드웨어[cpu] 조작 불가능
			
			
*/
	//필드
	private long sum;

	//메소드
	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}
	
	
	@Override
	public void run() {
	
		for (int i = 0; i <= 100; i++) { sum+=i;	}

	}

}
