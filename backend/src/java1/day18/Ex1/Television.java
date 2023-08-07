package java1.day18.Ex1;

public class Television implements RemoteControl{
	// 클래스명 implements 인터페이스명
	// 인터페이스가 선언한 추상메소드를 해당 클래스가 대신 구현 한다 / 로직을 클래스에서 짠다
	// 해당 추상메소드를 구현하기 전까지 오류 뜸
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("tv를 켭니다");
	}
	@Override
	public void trunOff() {
		System.out.println("tv를 끕니다");
	}
	
	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 tv의 볼륨은 : " + this.volume);
	}
		
	

}
