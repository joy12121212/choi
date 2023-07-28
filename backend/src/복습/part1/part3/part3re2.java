package 복습.part1.part3;

import java.util.Iterator;
import java.util.Scanner;

public class part3re2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		String[] 재고관리 = { "10,0,300,콜라", "10,0,200,환타", "10,0,100,사이다" };
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : ");
			
			int sc = scanner.nextInt();
			
			if (sc==1 || sc==2 || sc==3) {
				
				String 제품정보 = 재고관리[sc-1];
				
				int 재고 = Integer.parseInt(제품정보.split(",")[0]);
				int 바구니 = Integer.parseInt(제품정보.split(",")[1]);
				int 가격 = Integer.parseInt(제품정보.split(",")[2]);
				String 이름 = 제품정보.split(",")[3];
				
				if (재고 >0) {
					System.out.println("상품을 담았습니다"); 재고--; 바구니++;
				}else {
					System.out.println("재고가 부족 합니다");
	
				}
				재고관리[sc-1] = 재고+","+바구니+","+가격+","+이름;
			}// if
			
			else if (sc ==4) {
				
				System.out.printf("%10s %10s %10s \n" , "상품" , "수량" , "가격");
				
				for (int i = 0; i < 재고관리.length; i++) {
					
					int 바구니 = Integer.parseInt(재고관리[i].split(",")[1]);
					int 가격 = Integer.parseInt(재고관리[i].split(",")[2]);
					String 이름 = 재고관리[i].split(",")[3];
					
					if (바구니 >0) {
						System.out.printf("%10s %10s %10s \n" , 이름 , 바구니 , 바구니*가격);
					}
				}
			}
			
			
			
		}//while
		
	}//main

}//class
