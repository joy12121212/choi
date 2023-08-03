package java1.day16.Ex1_필드의다형성;

public class EX1_실행 {
	public static void main(String[] args) {
		
		//1. car 객체 생성
		Car myCar = new Car();
		System.out.println(myCar.tire); // 필드게 초기화가 없으면(데이터 대입) 기본값 출력
 		
		//2. Trie 필드에 Tire(); 메소드 대입 // 객체 생성
		myCar.tire = new Tire();
		System.out.println(myCar.tire);
		
		//3. 타이어 장착된 car 객체가 전진
		myCar.run();
		
		//4. 타이어 교체 하기위해 카센터에서 한국타이어 교체
		myCar.tire = new HankookTire();
		System.out.println(myCar.tire);

		
		myCar.run(); // 한국타이어 실행
		
		//5. 타이어 교체 하기 위해 카센터에서 금호타이어 교체
		myCar.tire = new KumhoTire();
		System.out.println(myCar.tire);
		  
		myCar.run(); // 금호타이어 실행
		System.out.println("--------------");
		KumhoTire kumhoTire = (KumhoTire)myCar.tire;
		System.out.println(kumhoTire);
		System.out.println(myCar.tire);
		myCar.run();
	}//main

}
