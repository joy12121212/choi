package java1.day10.Ex4;

public class Member {
	
	
	// 1. 필드
	
	// 2. 생성자
	
	// 3. 메소드

		// 리턴 x 매개변수 x 함수
	void signUp() {}//signUp
	
		// 리턴 x 매개변수 2개
	void login(String id , int pw) {}
	
		// 리턴 o 매개변수 x
	String findId() {return "하이";}
	
		// 리턴o 매개변수o
	
	String[] a = {"ddd","123"};
	String[] findPw(String a , String b) {return this.a;}
		
		// 가변인자 // [... : 여러 매개변수들을 하나의 힙에 저장, 힙주소 반환 vs new : 클래스 기반으로 힙에 객체 생성해서 주소반환
	
	void delete(String ...strings) {}
	void delete(int num, String ...strings) {}
	
		
	
}//class


/*

	메소드 : 객체의 동작 , 객체의 상호작용 , 서로다른 클래스간의 데이터 이동 [mvc2패턴]
		선언 : 리턴타입  메소드명 (매개변수 n개) {실행 코드 return}











*/