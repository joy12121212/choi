package java2.day22;

import java.awt.Toolkit;

// 얘는 재사용이 가능하다 // 여러번 사용 할거면 이게 좋음

public class 비프음 implements Runnable{ // run 메소드 오버라이드 필요
	
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
