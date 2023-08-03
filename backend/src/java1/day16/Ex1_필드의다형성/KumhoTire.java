package java1.day16.Ex1_필드의다형성;

public class KumhoTire extends Tire{
	// 상속 받으면 자식클래스에서 부모 클래스의 멤버를 사용할 수 있다
	@Override
	public void roll() {
		System.out.println("금호타이어 회전");
	}
}
