package java2.day22.Ex3;

import java.time.LocalTime;

public class 현재시간 implements Runnable {
	@Override
	public void run() {
		
		while (true) {
			System.out.println(LocalTime.now());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}//while
	}//run

}
