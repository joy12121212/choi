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
	
		// p158 .length() 문자열의 길이 알기
		System.out.println("주민등록번호길이 : " + ssn.length());
	
		// p159 . replace() 문자열내 특정 문자열 교체/치환/대체		
		String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String입니다.";
		// 문자열내 "자바" --> "java" 로 교체
		String newStr = oldStr.replace("자바", "java");
		System.out.println(oldStr);
		System.out.println(newStr);
		
		// p160 .substring()	: 문자열 자르기
		
		String ssn2 = "880815-1234567";
		String ssn3= ssn2.substring(7); // 해당 인덱스 이후로 전부 출력 // 앞은 생략
		System.out.println(ssn3);
		String ssn4 = ssn2.substring(0 , 6); // 시작인덱스 부터 마지막 인덱스의 전 까지 출력 // 0 1 2 3 4 5  6개 출력됨
		System.out.println(ssn4);

		// p164 .split()		: 문자열 분리
			// ssn2.split("-") : - 기준으로 분리
		
		System.out.println(ssn2.split("-")[1]);
		
		// p162 .indexOf()	: 문자 찾기
		
		String subject = "자바프로그래밍";
		int location = subject.indexOf("프로그래밍");
		if (location == -1) {
			System.out.println("못찾음");
		}else {
			System.out.println("찾음");
		}
		
		System.out.println(location);
		
		
	}//main

}

/*
	자바 문자열 사용하는 방법
		1. String 변수명 = "문자열"
		2. String 변수명 = new String("문자열")
		
		
	자바 문자열에서 제공해주는 라이브러리 = 미리 만들어진 함수
		문자열객채.메소드명()
		1. 문자열객체1.equals(문자열객체2) // 문자열 그 자체를 비교 true || false
		2. 문자열객체.charAt(인덱스)
		3. 문자열객체.length()
			vs 배열명.length
		4. 문자열객체.replace("기존문자열", "새로운문자열") 문자열내 "기존문자열" 이라는 문자열이 존재하면 "새로운문자열" 로 치환해서 반환
		5.
			문자열객체.split("분리기준문자") 
		6. 문자열.indexOf("찾고싶은문자열") // 문자열내 찾는 문자열이 존재하면 찾은 index를 반환 / 없으면 -1 반환




*/



