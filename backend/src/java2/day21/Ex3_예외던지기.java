package java2.day21;

public class Ex3_예외던지기 {
	public static void main(String[] args) {
		
		// p 478 예외 던지기 // 오류 이유를 알수가 없으니 메인 쓰레드 안에서는 트라이 캐치문으로 해라 // 자꾸 던지면 아무도 몰라
		
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			System.out.println("오류 발생 " + e.toString());
		}
		
	}

	
	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2");
		// 예외 발생 처리 방법 2가지
			// 1. try , catch : 해당 메소드에 직접 처리 하는 방법
			// 2. throws : 해당 메소드에 직접 처리 하지 않고 해당 메소드를 호출했던곳으로 예외 이동
				// 웹에서는 자동 예외처리가 가능 [ 서블릿 클래스 ]
	}
	
}
