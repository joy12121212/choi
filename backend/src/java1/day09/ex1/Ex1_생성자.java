package java1.day09.ex1;

import java1.day08.Ex4.Car;

public class Ex1_생성자 {
	public static void main(String[] args) {
		
		// 1. 객체생성 : 클래스명 객체변수명 = new 생성자명();
	
		car myCar = new car(); // 1개 이상의 생성자 선언했을때 기본생성자 더 만들어야 됨
		car myCar1 = new car("그렌저","검정",20);
		
	}
}
