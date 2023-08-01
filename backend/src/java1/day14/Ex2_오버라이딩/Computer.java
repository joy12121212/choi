package java1.day14.Ex2_오버라이딩;

public class Computer extends Calculator{
	// 지식클래스 extends Calculator
	// 자식 클래스에서 부모클래스 연동(필드, 생성자, 메소드) 가져다 쓸 수 있음
		//오버라이딩 : 자식 클래스는 부모클래스로부터 메소드를 물려 받았기 때문에
		// 자식 클래스에서 부모클래스와 동일한 이름으로 메소드를 선언 불가능
		// 오버로딩으로 선언 가능(매개변수 차이 주기)
	
	// 동일한 이름 매개변수 같으려면 - 오버라이딩 -> 재정의
	// 동일한 이름 매개변수 차이 주면 - 오버로딩 -> 새로 선언
	
	// 초록색 세모 == 오버라이드중
	@Override
	public double areaCircle(double r) {
			// {  } 안에 있는 코드를 재정의 한다 // 내맘대로 새로 짜도 됨
		System.out.println("컴퓨터 메소드 실행");
		return Math.PI * r * r;
	}
	
	
	
	
	
	
}//class
