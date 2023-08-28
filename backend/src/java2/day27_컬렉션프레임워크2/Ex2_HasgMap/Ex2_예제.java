package java2.day27_컬렉션프레임워크2.Ex2_HasgMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ex2_예제 {
	
	public static void main(String[] args) {
		// 1. map 컬렉션객체 내 < String , Integer > 2개 객체를 저장할 객체 선선
		
		Map<String , Integer> map = new HashMap<>();
		
		// 2. 객체 저장
		
		map.put("강아지", 10);
		map.put("공아지", 20);
		map.put("송아지", 30);
		map.put("공아지", 40); // key 중복 불가 , value 중복 가능 // key 중복일경우 새로운값으로 대체 공아지10 삭제
		
		System.out.println("map 상태 :"+ map );
		
		// 3. 객체 호출 .get(key) 
		System.out.println("홍길동 value : " + map.get("공아지"));
		
		// 4. map 객체 내 모든 key 호출
		
		System.err.println("map 모든 key 호출 : " + map.keySet());
		System.err.println("map 모든 values 호출 : " + map.values());
		
		// key 이용한 value 호출 가능 // 하지만 value 통해서 key 호출은 불가능
		
		
		// 5. 향상된  for map.keySet() : 모든 key 호출
		
		for (String key : map.keySet()) {
			System.out.printf("key %svalue : %d  \n" , key , map.get(key));
		}
		
		// forEach
		map.keySet().forEach(k -> {System.out.printf("key %svalue : %d  \n" , k , map.get(k) ); }
		);
		
		
		// ---------->ㅓ엔트리 < key , vlaue > 호출
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry);
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println("------------------------------------");
		map.entrySet().forEach(entry -> {
			System.out.println(entry);
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			
		});
		
	
	}//main
	

}
