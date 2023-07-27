package java1.day11.Ex4디자인패턴2.model.dto;

public class MemberDto { // 데이터 모델 / 형식 이동 객체
	//1. 필드


	private String id;
	private String pw;
	private String name;
	private String phone;
	private int age;

	
	//2. 생성자
	public MemberDto () {}  // 일단 만들어

	public MemberDto(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	} // 일단 만들어

	
	// 1. setter or getter	: 필드가 private 인 경우 간접 접근
	// 2. toString			: 내용물 확인
	
	//3. 메소드
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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

	
	// 2. toString			: 내용물 확인
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}



	
	
	
	
}
