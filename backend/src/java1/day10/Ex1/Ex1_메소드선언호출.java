package java1.day10.Ex1;
//233 ~ 234
public class Ex1_메소드선언호출 {
	//실행 목적
	public static void main(String[] args) {
		
		//1. 메소드 호출하기 위한 객체 생성
		Calculator myCal = new Calculator();
		
		//2. 객체를 통한 메소드 호출
		myCal.powerOn();
		
		//3. 객체를 통한 메소드 호출 // 매개변수 2개
		
		int a = myCal.plus(5, 6);
		System.out.println(a);
				
		//4. 객체를 통한 메소드 호출 // 매개변수 전달 = 2개 변수(값 , 주소) // 리턴 O
		
		int x = 10;
		int y =4;
		double result2 = myCal.divide(x, y); // divide 클래스에 매개변수 입력 후 결과값 리턴
		System.out.println("result2 : " + result2);
	}//main
	
	
	
	
	
	
}//class
