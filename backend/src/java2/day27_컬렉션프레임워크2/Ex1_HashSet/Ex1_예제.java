package java2.day27_컬렉션프레임워크2.Ex1_HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex1_예제 {
	
	public static void main(String[] args) {
		
		
		// 1. Set 컬렉션의 HashSet 객체 선언
		
		Set<String> set = new HashSet<>();
			// set객체(컬렉션 프레임워크)에 String 객체를 여러개 저장
		System.out.println("set 상태" + set);
		// 2. set 객체에 String 객체 저장
		set.add("java"); System.out.println("set 상태 + " + set);
		set.add("jdbc"); System.out.println("set 상태 + " + set);
		set.add("Jsp"); System.out.println("set 상태 + " + set);
		
		set.add("Jsp"); System.out.println("중복 발생" + set);
		set.add("spring"); System.out.println("set 상태 " + set);
		
		// 3. set 객체 내 String 객체 수
		 System.out.println("set 객체내 객체 수 : " + set.size());
		 
		// set / list 를 사용할거면 for 문 돌려서 찾아내야지
		 // 1. for 문 set 은 인덱스가 없으니 우째 찾노..?
		 for (int i = 0; i < set.size(); i++) { System.out.println("set은 인덱스가 없......");	}

		 // 2. 향상된 for 문 사용 해야지 ( 반복변수 : 컬렉션객체 )
		 // 	반복변수란 : 컬렉션 객체에 저장된 타입 // 스트링이면 스트링, 인트면 인트 짝 맞춰서 써라
		 for (String s : set) {System.out.println(s);}
	
		 // 3. forEach() 함수를 이용한 람다식 표현(화실표함수 = 자바 -> , 스크립트 =>)
		 set.forEach(s -> {System.out.println("화살표함수 " + s);});
		 
		 
		 
		 // ---------- 얘는  string , int 2개라서 재정의를 통하여 어떤걸 기준으로 중복제거를 할건지 잡아줘야 됨
		 
		 // 1. set 객체선언
		 Set<Member> set2 = new HashSet<>();
		 
		 // 2. set 객체에 member 객체 저장
		 set2.add(new Member("홍길동", 30));
		 set2.add(new Member("홍길동", 30));
		 set2.add(new Member("김치전", 30));
		 set2.add(new Member("부추전", 30));
		 set2.add(new Member("감자전", 60));
		 set2.add(new Member("감자전", 30));
		 
		 // 3. set 객체내 member 객체수
		 System.out.println("set 객체 내 member 객체수 : " + set2);
		 
		 
		 // 4. iterator() 메소드
		 	// set 객체에서 iterarot() 메소드 객체 얻기
		 Iterator<Member> iterator = set2.iterator();
		 	// iterator 객체를 이용한 반복분
		 while (iterator.hasNext()) { // 객체가 있으면 ture, 없으면 false
			 Member element = iterator.next();// .next() set객체 내 객체 호출
			 System.out.println(element);
			 if (element.name.equals("김치전")) { // 가져왔는데 김치전이 있다면
				iterator.remove();//remove() 사용해서 삭제
			}
		}
		 
		 // 확인하기
		 System.out.println("set 객체 내 member 객체수 : " + set2);
		 System.out.println(); 
		 //iterato 향상된 포문 
		 for (Member m : set2) {//인덱스를 사용하지 않고 순회 하는
			 System.out.println(m);	
		}
		System.out.println();
		
		// .forEach
		set2.forEach(m -> {System.out.println(m);});
		 
		 
		 
		 
		
		
		
		
		 
	}//main

}//class
