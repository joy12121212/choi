package 복습.part1.part2;

import java.util.Scanner;

public class part2re1 {
	
	public static void main(String[] args) {
		
		
		String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";
		
		Scanner scanner = new Scanner(System.in);
		
		
		int 콜라재고 = Integer.parseInt(재고관리.split("\n")[0].split(",")[0]);
		int 콜라바구니 = Integer.parseInt(재고관리.split("\n")[0].split(",")[1]);
		int 콜라가격 = Integer.parseInt(재고관리.split("\n")[0].split(",")[2]);
		
		int 환타재고 = Integer.parseInt(재고관리.split("\n")[1].split(",")[0]);
		int 환타바구니 = Integer.parseInt(재고관리.split("\n")[1].split(",")[1]);
		int 환타가격 = Integer.parseInt(재고관리.split("\n")[1].split(",")[2]);
		
		int 사이다재고 = Integer.parseInt(재고관리.split("\n")[2].split(",")[0]);
		int 사이다바구니 = Integer.parseInt(재고관리.split("\n")[2].split(",")[1]);
		int 사이다가격 = Integer.parseInt(재고관리.split("\n")[2].split(",")[2]);
		
		int 총금액 = 0;
		

		while (true) {
			
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); 
			
			int sc = scanner.nextInt();
			

			
			if (sc == 1) {
				if (콜라재고 <=0) {
					System.out.println("재고가 부족 합니다");
				}else {
					System.out.println("제품을 담았습니다"); 콜라재고--; 콜라바구니++; 총금액+=콜라가격;
				}
			}else if (sc == 2) {
				if (환타재고 <=0) {
					System.out.println("재고가 부족 합니다");
				}else {
					System.out.println("제품을 담았습니다"); 환타재고--; 환타바구니++; 총금액+=콜라가격;
				}
				
			}else if (sc==3) {
				if (사이다재고 <=0 ) {
					System.out.println("재고가 부족 합니다");
				}else {
					System.out.println("제품을 담았습니다"); 사이다재고--; 사이다바구니++; 총금액+=콜라가격;
				}
			} else if (sc==4) {
				
				System.out.println("콜라\t" + 콜라바구니+"\t" + (콜라바구니*콜라가격)+"\n"+"환타\t" + 환타바구니+"\t" + (환타바구니*환타가격)+"\n"+"사이다\t" + 사이다바구니+"\t" + (사이다바구니*사이다가격)+"\n");
				System.out.println("결제하실 금액은 : " + 총금액);
				
				int sc2 = scanner.nextInt();
				if (총금액 > sc2) {
					System.out.println("금액이 부족합니다.취소");
					콜라바구니 = 0; 콜라재고 = 10; 환타바구니 = 0; 환타재고 = 3; 사이다바구니 =0; 사이다재고 =2; 총금액 = 0;
				}else {
					System.out.println("결제가 완료 되었습니다 잔액 : "+ (sc2-총금액) );
					콜라바구니 = 0; 콜라재고 = 10; 환타바구니 = 0; 환타재고 = 3; 사이다바구니 =0; 사이다재고 =2; 총금액 = 0;
				}
			}

			
			
		}

		
		
		
	}

}


/*
2. 변수 초기값 

String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";

- 제품은 콜라 -> 환타 -> 사이다 순으로 작성되어 있으며 각 제품별 필드는 재고 -> 바구니 -> 가격으로 작성한 문자열 입니다.

3. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ]
1. 콜라 2.사이다 3.환타 4.결제
        [ 1~3 선택시 ]
            - 재고가 있을경우 바구니 담기 / 없으면 '재고부족' 출력

        [ 4 선택시 ]
            - 현재 바구니 현황 표시 목록[ * 바구니가 0보다 컸을경우에만 출력합니다 ]
                ----------------------------------
                    제품명 수량 가격
                    사이다 1 400
                    환타 2 1000
                    총가격 : 1400
            - 결제메뉴 표시
                1. 결제 2.취소
                    [결제 선택시]
                    - 금액을 입력받아 바구니의 총가격에 뺀 잔액 출력 -> 결제 성공시 바구니 초기화 하기
                    - 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
                    [취소 선택시]
                    - 장바구니 초기화 / 재고 다시 되돌리기
*/