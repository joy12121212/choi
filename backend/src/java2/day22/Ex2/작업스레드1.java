package java2.day22.Ex2;

public class 작업스레드1 implements Runnable{
	
	@Override
	public void run() {

		try {
			int i = 1;
		while (true) {
			Thread.sleep(5000); // 1초간 일시정지 - 예외처리 필수
			System.out.println(Thread.currentThread().getName()+"--작업 스레드1 5초마다 출력중 " + i);

			i++;
			if (i == 10) {
				break;
			}
		}//try
		}catch(Exception e) {System.out.println(e);}

	}//run

	
	
	

}
