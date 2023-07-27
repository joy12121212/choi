package 과제.과제10;

public class Member {
	private String id;
	private String password;
	private String name;
	private String phone;
	private int age;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Member() {} // 빈 생성자

	
	// 모든 필드를 저장하는 풀 생성자 -> 우클릭 -> 소스 -> using fields
	// 입력 받으면서 이걸통해 바로 때려박는다
	public Member(String id, String password, String name, String phone, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	
	
	// toString : 객체호출시 객체의 주소가 아닌 필드의 값을 반환[개발자가 검사용]
	// 우클릭 -> 소스 -> toString // 주소를 문자로 보여준다 // 아주 좋다
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", age=" + age
				+ "]";
	}
	
	

}




/*

	 jvm : 자바 가상 메모리
	 	- 자바는 하드웨어 조작x (직접적으로 메모리 관리 및 조작 불가)
	 	
			Member.java(자바코드파일)--->컴파일 클래스 로더----> Member.class(바이트코드파일)
			---> 메소드 영역 / 클래스 코드, 메소드 코드, 정적멤버 데이터
	- 키워드

	this	: 인스턴스 멤버 - new 힙생성시 할당 되고 힙 초기화될때
		-> static 키워드 없으면 인스턴스
		-> 객체를 만들어야만 사용 가능
		
	static	: 정적멤버 - 프로그램 시작시 할당되고, 프로그램이 종료될 때 [전역,공통,공용,공유]
		-> 전역변수 처럼 사용
		-> 객체 안만들어도 공용으로 사용 가능

	final	: 수정불가 - 초기화할때 대입만 가능하고 수정 불가능
	static final : 상수 - 프로그램내에서 1개만 저장(static) /수정불가(final) 합친거






	// 1. 필드 : 객체의 데이터를 저장하는 곳 = 인스턴스 vs 정적멤버 static
	
	// 2. 생성자 : 객체의 초기화를 담당 = 인스턴스 vs 정적멤버 static
	
	// 3. 메소드 : 객체이 행동을 담당 = 인스턴스 vs 정적멤버 static

		// toString : 객체호출시 객체의 주소가 아닌 필드의 값을 반환[개발자가 검사용]
		// 우클릭 -> 소스 -> toString



	DTO , VO
	https://maenco.tistory.com/entry/Java-DTO%EC%99%80-VO%EC%9D%98-%EC%B0%A8%EC%9D%B4

*/































