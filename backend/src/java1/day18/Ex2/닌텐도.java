package java1.day18.Ex2;

import java.util.Scanner;

public class 닌텐도 {
	
	public static void main(String[] args) {
		게임기 공소영패드;
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("1.동물의숲 2. 커비");
			
			int sc = scanner.nextInt();
			
			if (sc == 1) {
				공소영패드 = new 동물의숲();
				System.out.println("동물의 숲 시작");
			}//if
			else if (sc ==2) {
				공소영패드 = new 커비칩();
				
			}else {
				공소영패드 = new 동물의숲();
			}
			while (true) {
				String btn = scanner.next();
				if (btn.equals("A")) 공소영패드.A버튼();
				if (btn.equals("B")) 공소영패드.B버튼();
				if (btn.equals("X")) 공소영패드.X버튼();
				if (btn.equals("Y")) 공소영패드.Y버튼();
				if (btn.equals("Q")) break;
			}
			
		}//while
	}//main

}//class
