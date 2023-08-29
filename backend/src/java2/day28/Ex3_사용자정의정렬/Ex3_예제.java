package java2.day28.Ex3_사용자정의정렬;

import java.util.TreeSet;

public class Ex3_예제 {
	public static void main(String[] args) {
		// - Integer , String , Double 정렬 기준이 명확( 숫자 ,문자 이므로 )
		// - 사용자정의 클래스인 MemberDto( 여러개 필드 )
		
		//1. compareTo 메소드 [Comparable 인터페이스 (추상)] 이용한 정렬 기준 만들기
		
		
		// 1. Tree
		TreeSet<Person> treeSet = new TreeSet<>();
			// TreeSet 제네릭에는 Comparable 으로 구현된 클래스의 객체만 저장 가능
		// 2. 무작위 person 객체 대입
		
		treeSet.add(new Person("김세희", 35));
		treeSet.add(new Person("구일권", 40));
		treeSet.add(new Person("공소영", 38));
		System.out.println("나이순서 : " + treeSet); //디센딩 ?
		
		// int 순서대로 정렬하기 person 오버라이드 보면 된다		
	}

}
