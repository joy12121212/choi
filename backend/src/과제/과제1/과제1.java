package 과제.과제1;

import java.util.Iterator;

public class 과제1 {

	/*
	 * 1번 4 2번 6 7 3번 byte , boolean / short ,char / int , float / long , double 4번
	 * int , double / age , price / 10 , 3.14 5번 3 6번 1 7번 4 8번 3 9번 3 10번 2 11번 13
	 * , 16
	 * 
	 */

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}//for2
			for (int j2 = 0; j2 <= i; j2++) {
				System.out.print("*");
			}//for3

			System.out.println();
		} // for1

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}//for2
			for (int k = 0; k < 5-i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}//for1
		
		
	}//main
}//class

// 1. 연산자 암기 확인 2인 1조
// 2. 1인 책 73 ~ 76 풀이 // 카톡방에 깃 주소 올리기