package java1.day14.Ex2_오버라이딩;

public class Ex2_실행 {
	public static void main(String[] args) {
		int r = 10;
		
		// 부모 객체 생성
		Calculator calculator = new Calculator();
		// 부모가 부모꺼 호출
		System.out.println("원 면적 : " + calculator.areaCircle(r));
		
		// 자식 객체 생성
		Computer computer = new Computer();
		// 자식이 부모꺼 호출
		System.out.println("원 면저 : " + computer.areaCircle(r));
		
		
	}

}
