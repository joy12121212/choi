package java1.day09.ex2;

public class Korean {
	//1. 필드
		String nation = "대한민국";	//1. 객체마다 동일한 값을 가지고 있다면 / 객체의 필드값 미리 초기화
		String name;				//2. 객체마다 다른 값을 가져야 한다면 / 객체의 필드값 기본값 / 생성자 사용 권장
		String ssn;
	//2. 생성자
		
		// 기본 생성자
		public Korean() {};
		
		//1. 매개변수 2개 생성자
		public Korean(String name , String ssn) { // 가독성을 위해 매개변수명와 필드명을 같게 하도록 권장
			this.name = name; this.ssn=ssn;
			//this. -> 매개변수: 외부로부터 들어온 변수명이 동일할때
		}
		//2. 매개변수 2개 생성자
//		public Korean( String name1, String ssn2) {} //얘는 안된다야

		//3. 매개변수 2개 생성자 / 타입 다르게
		public Korean( int name1, String ssn2) {} //얘는 된다		
		
		//4. 매개변수 2개 생성자 / 순서 다르게
		public Korean( String ssn2, int name1) {} //얘는 된다		
		
		//5. 매개변수 3개 생성자 
		public Korean( String name1, String ssn2 , String nn1)
		{this(name1,ssn2);} //얘는 된다//3개를 만들어놓고 2개만쓴다		
		

		
		
		//3. 메소드
	
}
