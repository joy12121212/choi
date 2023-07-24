package java1.day08;

public class Ex2_선언 {
	public static void main(String[] args) {
		// 데이터 = 필드 , 객체의 행동 = 메소드
		
		// 1. 객체 만들기/선언 : 클래스명 변수명 = new 생성자명();
		Student s1 = new Student();
			// 1. Student : Student 클래스를 가져와서 설계도로 사용
			// 2. s1 : Student 객체의 주소값을 저장할 스택영역의 지역변수
			// 3. new : 객체 생성하고 생성된 주소값을 스택영역 지역변수에게 반환
			// 4. Student(); : 객체 생성시 초기값/처음값을 넣어서 필드에 저장할 수 있는 메소드
		
		System.out.println(" s1 변수가 Student 객체의 주소를 가지고 있다" + s1);
		// . (도트연산자) : 변수명.메소드() / 변수명.필드명 -> 변수가 가지고있는 주소로 이동, 필드/메소드 사용
		// int 정수 = 10; -> 도트연산자 사용 불가/주소값을 저장한게 아니라 값 자체를 스택에 저장했기에
		// Integer 정수객체 = 10; 정수객체.메소드(); 사용 가능 / Integer 는 클래스 이므로
		
		//2. 객체 하나 더 만들기 // s1 과 s2는 다르다 // new는 힙 영역에 생성, 주소 할당
		Student s2 = new Student();
		
		// 3. Student 설계도/ 클래스는 같지만 다른 객체가 생성 된다
		// s2변수가 또 다른 Student 객체의 주소를 가지고 있다.
		System.out.println(s1 == s2);
	}

}
