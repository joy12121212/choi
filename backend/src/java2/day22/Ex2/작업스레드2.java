package java2.day22.Ex2;

public class 작업스레드2 extends Thread{
	
	@Override
	public void run() {

		try {
			int i = 1;
		while (true) {

			Thread.sleep(3000); // 1초간 일시정지 - 예외처리 필수
			System.out.println(Thread.currentThread().getName()+"--작업스레드2 3초마다 출력중 " + i);
			i++;
			if (i == 10) {
				break;
			}
		}//try
		}catch(Exception e) {System.out.println(e);}

	}//run

}
