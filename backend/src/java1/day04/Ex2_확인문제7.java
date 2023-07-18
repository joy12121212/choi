package java1.day04;

import java.util.Scanner;

public class Ex2_확인문제7 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		boolean run = true;


		
		while (run) {

			int inM = 0;

			
			System.out.println("-----------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------");

			System.out.print("선택> ");
			int money = scanner.nextInt();
			
			if (money == 1) {
				System.out.println("예금액> " );
				inM += scanner.nextInt();

			}else if(money == 2) {
				System.out.println("출금액> " );
				inM -= scanner.nextInt();
			}else if(money == 3) {
				System.out.println("잔액> "+ inM );
			}else if (money == 4) {
				System.out.println("프로그램 종료");
				run = false;
			}
		}
		
		
	}//main

}
