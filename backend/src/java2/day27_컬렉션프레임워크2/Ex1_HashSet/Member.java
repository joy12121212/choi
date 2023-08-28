package java2.day27_컬렉션프레임워크2.Ex1_HashSet;

public class Member {
	public String name;
	public int age;

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	
	// ---------------해당객체의 기준 만들기 --------------//
		
	@Override	// (Object 모든 클래스는 로부터 자동으로 상속 받음) 메소드를 재정의
	public int hashCode() {
		return name.hashCode()+age;

	}
	
//	@Override 
//	public boolean equals(Object obj) { // java ver. 16 이상에서 사용 가능해서 주석처리함
//		if (obj instanceof Member target) {
//			//만약에 해당 객체가 name 과 age 가 일치하면 ture
//			return target.name.equals(name) && (target.age == age);
//		}else {
//			return false;
//		}
//	}
//
//	@Override
//	public String toString() {
//		return "Member [name=" + name + ", age=" + age + "]";
//	}
	
	
	

}
