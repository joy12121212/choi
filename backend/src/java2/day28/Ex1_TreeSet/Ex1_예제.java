/*

	검색 기능을 강화시킨 컬렉션
		- 컬렉션 안에 있는 데이터를 검색할때 효율성 제공 [ 필수 x ]
		? 7을 찾는다
		- 1 2 3 4 5 6 7 8 9 -> 빠름 
		- 4 2 3 6 5 1 8 9 7 -> 느림

		- 이진트리
			- 각 노드는 최대 2개의 노드를 연결
			- 부모 노드 보다 크면 오른쪽 , 작으면 왼쪽
			
			- 6 8 10 이진트리 표현
			
					부모노드(8)
					/		\
			자식노드(6)		자식노드(10)
			


 */

package java2.day28.Ex1_TreeSet;

import java.util.TreeSet;

public class Ex1_예제 {
	
	public static void main(String[] args) {
		
	// 1. TreeSet 객체 생성
	TreeSet<Integer> scores = new TreeSet<>();
	
	// 2. 무작위로 숫자 저장
	scores.add(87);
	scores.add(20);
	scores.add(71);
	scores.add(15);
	scores.add(65);
	scores.add(84);
	scores.add(91);
	scores.add(05);	// 87 20 71 15 65 84 91 05 로 저장되는게 아니라
	System.out.println("이진트리상태 "+scores); //이진트리상태[5, 15, 20, 65, 71, 84, 87, 91]  자동 정렬 해준다
	
	// 3.
	System.out.println("가장오른쪽 노드 : "+ scores.last());
	System.out.println("가장왼쪽 노드 : "+ scores.first());
	System.out.println("95아래 노드 : "+ scores.lower(95));
	System.out.println("95위 노드 : "+ scores.higher(95));
	System.out.println("95점이거나 아래 노드 : "+ scores.floor(95));
	System.out.println("95점이거나 위 노드 : "+ scores.ceiling(95));
	
	
	// 4. 내림차순
	System.out.println("이진트리 내림차순 : "+ scores.descendingSet());
	
	// 5. 범위 검색 [ ture 이상 , false 초과 ]
	System.out.println("이진트리 80이상 : "+ scores.tailSet(80,true));
	System.out.println("이진트리 80이상 90 미만 : "+ scores.subSet(80, true , 90, false));
	
	
	}//main

}//class





