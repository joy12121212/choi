package java1.day14.Ex3_부모메소드호출;

public class SupersocinAirplane extends Airplane{
		// 자식 크랠스 extends 부모클래스명
		// ! : 자식 클래스엣 부모클래스의 구성 멤버를 사용할 수 있다
		// !! : 단 부모클래스는 자식 클래스의 구성멤버를 사용할 수 없다
	
	// 1. 필드
	public static final int NOMAL = 1;
	public static final int SUPERSONIC = 2;
	public int flyMode = NOMAL;
	// 2. 생성자
		public SupersocinAirplane() {
			super();
		}
	// 3. 메소드
		// 부모 클래스로부터 오버라이딩
	@Override
	public void fly() {
		if (flyMode == SUPERSONIC) {
			System.out.println("초음속 비행 합니다");
		}else {
			super.fly();
		}
		super.fly();
	}
	

	
}


/*
	
			  this			vs			super
			  현재클래스					부모클래스
	필드		this.필드명;				super.필드명;
	생성자	this();					super();
	메소드	this.메소드명():			super.메소드명();
		
	










*/