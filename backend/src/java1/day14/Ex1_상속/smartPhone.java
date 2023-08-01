package java1.day14.Ex1_상속;

public class smartPhone extends phone{
	
	// 클래스 구성 멤버 // 상속 extends[연장하다]
		// 자식클래스 : smartPhone  // 부모 : phone
		// 자식은 부모꺼 가져다 쓴다
		// phone 클래스에서 smartPhone 클래스의 구성멤버를 사용할 수 없음
	
		// java는 100% 객체지향 언어 = 상속 문법 사용
	/*
	
		최상위 Object
			그 아래 나머지 클래스들 toString , String , scanner ... ~~
	
	
	
	*/
	// 1. 필드
		public boolean wifi;
	// 2. 생성자
		public smartPhone (String model , String color){
			//this.model = model;
			
			//상속 후
			this.model = model;
			this.color = color;
		}
	// 3. 메소드
		
		
		public void setWifi( boolean wifi) {
			this.wifi = wifi;
			System.out.println("와이파이 상태를 변경 했습니다");
		}
		public void internet() {
			System.out.println("인터넷에 연결 합니다.");
		}
}
