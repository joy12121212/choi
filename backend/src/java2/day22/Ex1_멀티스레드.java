package java2.day22;

import java.awt.Toolkit;
import java.util.Iterator;

public class Ex1_멀티스레드 {
	
	public static void main(String[] args) { // 메인스레드가 main 메소드를 호출
		//메인스레드는 보이지 않는다 // 그냥 존재 한다
		System.out.println("싱글 스레드 시작");
		// p 596
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// 5번 비프음 발생 시켰는데 실제 들리는건 한번... [ 비프음보다 for 문 도는게 더 빨라서 1번만 송출됨]
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
		}
		
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			// 0.5초간 딜레이 발생 시킬 수 있다//메인스레드를 잠깐 멈춘다
			try {
				Thread.sleep(500); //밀리초는 1 / 1000 초   500 == 0.5초
			} catch (InterruptedException e) {System.out.println(e);}
		}//for
		
		for (int i = 0; i < 5; i++) {
			System.out.println("땡");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		System.out.println("멀티 스레드 시작");
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ멀티스레드ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//
		// main 스레드 외 작업 스레드 객체 만들기
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						System.out.println(e);
					}//try catch
				}//for
			}//run
		});// 생성자 
		
		
		// 작업 스레드 시작
		
		thread.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("땡");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
		System.out.println("멀티 스레드 구현체");
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ멀티스레드 구현체ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//		
		
		비프음 비프음 = new 비프음();	// Runnable 인터페이스 구현한 객체 [ 구현체 ]
		Thread thread2 = new Thread(비프음);		// Runnable 구현체를 Thread 객체에 전달
		thread2.start();	// Thread 클래스에 start() 실행시 run 메소드 실행 됨
		
		
		
		System.out.println("스레드 자식 클래스");
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ멀티스레드 구현체ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//	
		
		비프음2 비프음2 = new 비프음2();
		비프음2.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("땡");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
		}		
		
		
		
		
		
		
		
		
		
	}//main

}//class



/*

	프로그램 : 명령문의 집합
		- 프로세스 : 실행중인 프로그램
		- 멀티태스킹 : 두가지 이상의 작업을 동시에 처리하는 것
		- 멀티 프로세스
	
	프로세스 2			프로세스1
	스레드1				스레드1
						스레드2
						
		* 멀티프로세스가 프로그램단위의 멀티태스킹 이라면
		* 멀티스레드는 프로그램 내부에서의 멀티태스킹 이냐? ㅇㅇ
				
		- 멀티 프로세스는 서로 독립적이다 // 서로 영향을 안 받는다
			- 한글(프로세스) , 엑셀(프로세스) , 동시에 사용할때 한글이 오류가나도 엑셀은 영향 없음
		- 멀티 스레드는 프로세스 내부에서 생성되므로 하나의 스레드가 오류가 발생하면 프로세스가 종료 된다 // 서로 영향을 받는다
			- 카카오톡(프로세스)에서 채팅 + 사진 보내기(스레드+스레드) 기능 사용중 채팅이 오류가 생기면 사진 보내기도 안된다 
		
	멀티스레드 : 병렬로 데이터를 처리하는 곳에서 사용한다
		1. 사용처 : 웹, 앱 , 서버 등등
		2. 메인스레드 : 모든 자바 프로그램은 '메인 스레드'가 -> '메인 메소드'를 실행 하면서 시작 된다
		3.
			싱글 스레드 : main 메소드만 사용하는 경우[메인이 종료되면 프로세스 종료]
			멀티 스레드 : main 메소드에 새로운 작업 스레드를 생성하는 경우[모든 스레드가 종료되면 프로세스 종료]
		4. 스레드 생성
			Thread 클래스
				1. Thread 변수명 = new Thread(Runnable 구현객체);
				- start() : run 메소드 호출		// (2)얘로 시작 한다
		5.
			Runnable : 스레드가 작업을 실행할대 사용하는 인터페이스
				run 메소드 : 재정의 해야 된다 // 오버라이드
				run() : [추상메소드] 작업 스레드 실행 코드 정의		// (1)얘로 정의 하고 
			
		6. 익명[이름없는] 객체
			익명객체
				클래스명 클래스 = new 클래스명(){오버라이딩 메소드}
					비프음2 비프음3 = new 비프음2() { public void run() {} };
			익명 구현체
				클래스명 클래스 = new 클래스명 (new 인터페이스명() {오버라이딩 메소드})
					Thread thread = new Thread( new Runnable() {} };

*/







