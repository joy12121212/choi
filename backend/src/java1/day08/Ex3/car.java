package java1.day08.Ex3;

//현 클래스의 사용 목적 : 설계도
public class car {//class

	
	// 1. 필드	: 객체의 데이터를 저장하는 곳 * 변수와 비슷하지만 다름
	String model;	// 선언시 new 연산자 사용하지 않았기 때문에 기본값인 null
	boolean start;	// 선언시 new 연산자 사용하지 않았기 때문에 기본값인 false
	int speed;		// 선언시 new 연산자 사용하지 않았기 때문에 기본값인 0	
	
	// 2. 생성자	: 객체 생성시 초기화 역할 * 클래스명과 동일 해야 함
	
	// 3. 메소드	: 객체의 동작을 위해 호출, 실행하는 블록
	void method(){System.out.println(model);} // 클래스 안에서 쓰는거니 도트연산자 사용 안해도 됨
}//class
