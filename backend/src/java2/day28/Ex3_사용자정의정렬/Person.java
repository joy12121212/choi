package java2.day28.Ex3_사용자정의정렬;

public class Person implements Comparable<Person>{
	// 메소드 [ 정렬 기준 만들기 ]
		// 1. Comparble 인터페이스
		// 2. compareTo메소드 구현
	//필드
	public String name;
	public int age;
	
	
	// 인트 순으로 정렬하기
	
	@Override
	public int compareTo(Person o) {
		if (age < o.age) return -1;
		else if (age == o.age) {return 0;}
		else {return 1;}
			
	
	}
	
	
	// 생성자
	public Person(String name, int age) { 
		super();
		this.name = name;
		this.age = age;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	

}
