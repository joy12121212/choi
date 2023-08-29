package java2.day28.Ex4_스택과큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex4_스택예제 {
	public static void main(String[] args) {
		
		
		// 1. stack 객체 선언
		Stack<Coin> coinBox = new Stack<>();
		
		// 2. 무작위로 동전(객체) 넣기
		coinBox.add(new Coin(100));
		coinBox.add(new Coin(50));
		coinBox.add(new Coin(5000));
		coinBox.add(new Coin(10));
		
		System.out.println("스택의 상태 : "+ coinBox);
		
		// 3. stack 객체에서 동전(객체) 꺼내기
		coinBox.pop(); // 나중에 들어온//맨 마지막꺼 삭제 됨
		System.out.println(coinBox);
		
		
		System.out.println("----------------------------");
		
		// 1. Queue 구현체[LinkedList](동전케이스) 선언
		
		Queue<Coin> coinBox2 = new LinkedList<>();
		
		// 2. 무작위로 동전(객체) 넣기
		coinBox2.offer(new Coin(100));
		coinBox2.offer(new Coin(50));
		coinBox2.offer(new Coin(5000));
		coinBox2.offer(new Coin(10));
		System.out.println("큐 상태 : " + coinBox2);
		
		coinBox2.poll(); // 먼저 들어온 값이 삭제 된다
		System.out.println("큐 상태 : " + coinBox2);
		
		
		
		
		
		
		
	}//main

}
