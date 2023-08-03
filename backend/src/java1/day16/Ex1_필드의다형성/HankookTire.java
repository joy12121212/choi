package java1.day16.Ex1_필드의다형성;

public class HankookTire extends Tire{
	// 상속 : 자식클래스명 뒤에 extends 부모클래스명
	//오버라이딩 : 부모클래스의 메소드를 물려 받았지만, 리모델링(재정의) 한다
	
	@Override
	public void roll() {
		// super.roll(); 부모꺼 호출한다 인데 재정의 할거니까 이거 안 씀
		//새로운 코드 작성 == 재정의
		
		System.out.println("한국타이어 회전");
		
	}
}
