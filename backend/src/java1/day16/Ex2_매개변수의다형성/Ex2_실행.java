package java1.day16.Ex2_매개변수의다형성;

public class Ex2_실행 {
	public static void main(String[] args) {

		//0.
		Driver driver = new Driver();
		
		//1. 부모객체
		Vehicle vehicle = new Vehicle();
		System.out.println("차 확인");
			driver.Drive( 3, vehicle);	// 객체의 타입과 매개변수 타입이 일치해서 가능
		
		//2. 자식객체
		Bus bus = new Bus();
		System.out.println("버스 확인");
			driver.Drive(5, bus);		// 객체의 타입[Bus] 매개변수의 타입[Vehicle]
		
		Taxi taxi = new Taxi();			// 매개변수 타입 + 부모, 자식 타입 모두 대입 가능
		System.out.println("택시 확인");
			driver.Drive(5 , taxi);
		
		
	}

}
