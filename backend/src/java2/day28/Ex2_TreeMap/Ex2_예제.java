package java2.day28.Ex2_TreeMap;

import java.util.TreeMap;

public class Ex2_예제 {
	public static void main(String[] args) {
		
		
		// 1. TreeMap 객체 생성
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		
		// 2. 무작위 엔트리<키 , 값> 저장
		treeMap.put("apple", 10);
		treeMap.put("forever", 60);
		treeMap.put("description", 40);
		treeMap.put("ever", 50);
		treeMap.put("zoo", 30);
		treeMap.put("base", 20);
		treeMap.put("cherry", 80);
		
		System.out.println(treeMap);
		
		// 오름차순 : 낮은 - > 끝 (123 , abc , ㄱㄴㄷ) //자동으로 오름차순으로 정렬 됨 / 기준은 key
		
		
		// 3.
		System.out.println("가장 왼쪽 노드 : " + treeMap.firstEntry());
		System.out.println("가장 오른쪽 노드 : " + treeMap.lastEntry());
		System.out.println("ever 왼쪽 노드 : " + treeMap.lowerEntry("ever"));
		System.out.println("ever 오른쪽 노드 : " + treeMap.higherEntry("ever"));
		System.out.println("ever 이거나 왼쪽 : " + treeMap.floorEntry("ever"));
		System.out.println("ever 이거나 오른쪽 : " + treeMap.ceilingEntry("ever"));
		
		// 4. 내림차순
		
		System.out.println("이진트리 map 내림차순 : " + treeMap.descendingMap()); // key 값 기준 내림 차순
		
		
		System.out.println("a~c 까지 c 미포함 : "+ treeMap.headMap("c",false));		// a부터 c
		System.out.println("c~z 까지 : "+ treeMap.tailMap("c",true));				// 전체
		System.out.println("c~h 사이의 노드 : "+ treeMap.subMap("c",true, "h", false));
		
		
		
		
	}//main

}
