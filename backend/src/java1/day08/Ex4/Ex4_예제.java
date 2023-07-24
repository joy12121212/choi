package java1.day08.Ex4;
//실행 목적
public class Ex4_예제 {
	public static void main(String[] args) {
		
		// 1. Car 객체 선언 : 클래스명 변수명 = new 생성자명();
		Car myCar = new Car(); // Car 클래스 주소를 myCar에 대입
		
		// 2. 객체를 이용한 필드 호출
		System.out.println(myCar.company);
		// myCar 변수 안에 저장된 Car 클래스의 주소를 활용하여 Car 클래스의 company 값을 호출
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		System.out.println(myCar.maxSpeed);
		// speed 변수의 값을 수정
		myCar.speed = 60;
		System.out.println("수정된 속도 : " + myCar.speed);
		
		// --------
		Car yourCar = new Car();
		System.out.println("니네집 차 : " + yourCar.speed);
		
		myCar = yourCar;
		
		System.out.println("우리집에 너네집 대입 "+ myCar.speed);
		System.out.println("너네집꺼 "+yourCar.speed);
	}//main

}//class
