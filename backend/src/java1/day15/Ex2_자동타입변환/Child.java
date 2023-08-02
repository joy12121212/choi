package java1.day15.Ex2_자동타입변환;

public class Child extends Parent{
			// child extends Parent -> 상속
	
	@Override
	public void method1() {
		System.out.println("자식클래스 메소드1");
	}
	
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		super.method2();
	}
	
}
