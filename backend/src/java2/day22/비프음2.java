package java2.day22;

import java.awt.Toolkit;

public class 비프음2 extends Thread{ // 상속 

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {

			try {
				toolkit.beep();
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		} // for

	}// run
}
