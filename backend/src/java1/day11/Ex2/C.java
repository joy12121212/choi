package java1.day11.Ex2;

import java1.day11.Ex1.B;

public class C {
	
	//1. A 와 C 는 다른 패키지 이지만 A클래스가 default
	// A a = new A();

	//2. b와 c클래스는 다른 패키지이지만 B가 public 이라 접근 가능
	B b = new B();
	
	//3. c클래스 private 생성자
	private C() {} 

}
