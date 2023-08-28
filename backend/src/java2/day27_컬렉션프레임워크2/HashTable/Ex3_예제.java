package java2.day27_컬렉션프레임워크2.HashTable;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Ex3_예제 {
	public static void main(String[] args) {
		
		
		// 1. HashTable 객체에 String , Integer 2개 객체를 저장하는 map 객체 선성// [ 동기 = 여러 쓰레드가 동시에 한 메소드에 요청할대 대기상태 ]
		Map<String, Integer> map = new Hashtable<>();  //new HashMap<>(); // 이거는 2000개 저장 안되거나 오류 발생 [ 비동기 = 여러 쓰레드가 동시에 한 메소드에 요청할대 대기상태 없으면 ]
		
		// 2. 멀티 스레드를 이용한 각 1000개씩 2000개를 동시 저장
		
		Thread threadA = new Thread() {
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					map.put(String.valueOf(i), i);
				}
			};
		};//treadA

		Thread threadB = new Thread() {
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					map.put(String.valueOf(i), i);
				}
			};
		};// threadB
		
		threadA.start(); threadB.start();	// 스레드 두개 실행
		
		// main 스레드는 다른 두 스레드가 작업(저장완료) 될때까지 main 스레드 대기 상태로 만든다
		try {
			threadA.join(); threadB.join();
		} catch (Exception e) {	}
		
		System.out.println("map 객체 수 : " + map.size());
		System.out.println("map 상태 : " + map);		// 두 스레드가 저장하기 전에 main 스레드 출력이 먼저 되어서 join 필요하다
		
		
		
		
	}//main

}
