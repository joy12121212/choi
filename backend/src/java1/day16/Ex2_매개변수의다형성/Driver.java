package java1.day16.Ex2_매개변수의다형성;

public class Driver {
	public void Drive(int value , Vehicle vehicle) {
		// 자동 타입 변환되어 들어온다 //자식이 부모로 강제 타입 변환 됨//그래서 다시 자식으로 타입 변환 가능함

	
		System.out.println("바이클 타입 확인" + (vehicle instanceof Bus)); // Bus 타입에서 가져온거 맞습니까? 라고 확인하는 방법

		System.out.println("바이클 타입 확인" + (vehicle instanceof Taxi)); // Taxi 타입에서 가져온거 맞습니까? 라고 확인하는 방법

		
		if (vehicle instanceof Bus) {
			System.out.println("버스전진");
		}
		if (vehicle instanceof Taxi) {
			System.out.println("택시전진");
		}
		
		
		vehicle.run();
	}
}//class
