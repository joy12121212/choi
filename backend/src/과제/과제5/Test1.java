package 과제.과제5;

import java.util.Iterator;
import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		

		String[] 재고관리 = {"10,0,300,콜라" , "10,0,200,환타" , "10,0,100,사이다" };
		
		while (true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			
			
			if (ch ==1 || ch == 2 || ch == 3) {
				
				String 제품정보 = 재고관리[ch-1]; // ch는 1~3 사이 -> -1 빼면 재고관리 배열의 0 1 2 인덱스와 동일
				
				int 재고 = Integer.parseInt(제품정보.split(",")[0]);
				int 수량 = Integer.parseInt(제품정보.split(",")[1]);
				int 가격 = Integer.parseInt(제품정보.split(",")[2]);
				String 이름 = 제품정보.split(",")[3];
				
				if (재고 == 0) {
					System.out.println("재고부족");
				}else {
					재고--; 수량++; System.out.println("바구니에 담았습니다");
					
				}//else
				재고관리[ch-1] = 재고+","+수량+","+가격+","+이름;
			}//if
			else if (ch == 4) {
				System.out.printf("%10s %10s %10s \n" , "제품명" , "수량" , "가격");
				
				for (int i = 0; i < 재고관리.length; i++) {
					

					int 수량 = Integer.parseInt(재고관리[i].split(",")[1]);
					int 가격 = Integer.parseInt(재고관리[i].split(",")[2]);
					String 이름 = 재고관리[i].split(",")[3];
					
					if (수량 > 0) {
						System.out.printf("%10s %10s %10s \n", 이름 , 수량 , 가격*수량);
					}//if
				}//for
			}//else if
				
			
		}//while
				
	}//main

}
