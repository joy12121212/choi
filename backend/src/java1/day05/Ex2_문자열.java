package java1.day05;

public class Ex2_문자열 {
	public static void main(String[] args) {
		
		
		//153p
		
		String name1 = "홍길동";
		String name2 = "홍길동";
			// ??? : 두 스택영역의 지역변수가 참조하는 주소는 같을까?
		System.out.println(name1 == name2);
		
		String name3 = new String("홍길동");
		String name4 = new String("홍길동");
		
		System.out.println(name1 == name3);
		System.out.println(name4 == name3);
		
		
		// p 156
		if (name1 == name2) { // "" 문자열 리터럴로 생성된 문자열 개체 비교
			System.out.println("두 문자 열은 같습니다");
		}else {
			System.out.println("두 문자열은 다릅니다");
		}
		if (name3 == name4) { // 객체의 주소를 비교
			System.out.println("두 문자 열은 같습니다");
		}else {
			System.out.println("두 문자열은 다릅니다");
		}
		if (name3.equals(name4)) { // 각 개체의 "문자열 자체" 를 비교
			System.out.println("두 문자 열은 같습니다");
		}else {
			System.out.println("두 문자열은 다릅니다");
		}
		
		// p157 문자열 내에서 특정 문자 추출/꺼내기
		String ssn = "9506241230123"; // 문자열 개체 선언 글자수 13 인덱스 0 ~ 12
		
		char sex = ssn.charAt(6);

		if (sex == '1' || sex == '3' ) {
			System.out.println("남자 입니다");
		}else {
			System.out.println("여자 입니다");
		}
	
		// p158
		System.out.println("주민등록번호길이 : " + ssn.length());
	
	
	
		
		
	}//main

}

/*
	자바 문자열 사용하는 방법
		1. String 변수명 = "문자열"
		2. String 변수명 = new String("문자열")
		
		
	자바 문자열에서 제공해주는 라이브러리 = 미리 만들어진 함수
		문자열객채.메소드명()
		1. 문자열객체1.equals(문자열객체2) // 문자열 그 자체를 비교 true || false
















*/



