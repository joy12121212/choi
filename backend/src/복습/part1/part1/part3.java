package 복습.part1.part1;

import java.util.Scanner;

public class part3 {
	public static void main(String[] args) {
		
	    int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
	    int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
	    int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
	    
	    int 총금액 = 0;
	    
	    Scanner scanner = new Scanner(System.in);
	    
	    while (true) {
			
	    	System.out.println("1.콜라 2. 환타 3. 사이다 4. 결제");
	    	int sc = scanner.nextInt();
	    	
	    	if (sc==1) {
				if (콜라재고 < 0) {
					System.out.println("재고가 부족 합니다");
				}else {
					콜라재고--; 콜라바구니++; System.out.println("상품을 담았습니다"); 총금액+=콜라가격;
				}	
			}
	    	else if (sc == 2) {
				if (환타재고 < 0) {
					System.out.println("재고가 부족 합니다");
				}else {
					환타재고--; 환타바구니++; System.out.println("상품을 담았습니다"); 총금액+=환타가격;
				}	
			}
	    	else if (sc == 3) {
	    		if (사이다재고 < 0) {
	    			System.out.println("재고가 부족 합니다");
	    		}else {
	    			사이다재고--; 사이다바구니++; System.out.println("상품을 담았습니다"); 총금액+=사이다가격;
	    		}	
	    	}
	    	else if (sc==4) {
				System.out.println("1.결제 2.취소");
				int sc2 = scanner.nextInt();
				
				if (sc2 == 1) {
					System.out.println("콜라\t"+콜라바구니+"\t"+(콜라가격*콜라바구니));
					System.out.println("환타\t"+환타바구니+"\t"+(환타가격*환타바구니));
					System.out.println("사이다\t"+사이다바구니+"\t"+(사이다가격*사이다바구니));
					System.out.println("결제할 금액 : " + 총금액);
					
					int sc3 = scanner.nextInt();
				
					if (sc3 >= 총금액) {
						System.err.println("결제 완료" + "잔액"+(sc3 - 총금액));
						콜라재고 = 10; 환타재고 = 3; 사이다재고 = 2; 콜라바구니 = 0; 환타바구니 =0; 사이다바구니 =0; 총금액 =0;
					}else if (sc3<=총금액){
						System.out.println("금액이 부족 합니다");
						콜라재고 = 10; 환타재고 = 3; 사이다재고 = 2; 콜라바구니 = 0; 환타바구니 =0; 사이다바구니 =0; 총금액 =0;
					}
				}
			}//else if 4
		}// while
	}

}
/*
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