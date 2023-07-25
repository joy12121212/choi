package java1.day09.ex2;

public class Ex2_필드초기화 {
	public static void main(String[] args) {
		
		// 1. 객체 생성
			//1. 기본생성자 : 객체 생성시 초기화x
		Korean k = new Korean();
		System.out.println(k.nation);
		System.out.println(k.name);
		
		
		Korean k1 = new Korean("박자바", "010235-1234567");
		System.out.println(k1.nation);
		System.out.println(k1.name);
		
		System.out.println(k.name);
		
		Korean k2 = new Korean("김자바" , "01010-101010");
		System.out.println(k2.name);

	}

}


/* 오버로딩 : 동일한 메소드명 여러개 선언 가능
		기존은 동일한 메소드명을 선언 불가 -> 왜 ? 식별불가해서
			// 매개변수의 개수/타입 이용한 메소드 식별















*/