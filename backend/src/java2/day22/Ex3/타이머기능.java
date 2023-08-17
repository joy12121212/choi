package java2.day22.Ex3;

public class 타이머기능 implements Runnable{
	
	@Override
	public void run() {
		int second = 0;
		
		while (true) {
			try {
				Thread.sleep(1000);
				second++;
				System.out.println("타이머 " + second);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

}
