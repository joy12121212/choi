package java1.day04;

import java.util.Iterator;
import java.util.Scanner;

public class Ex1_반복문 {
	public static void main(String[] args) {
		
		int sum = 0;
		sum= sum+1;		// sum+=sum
		
		//for문을 이용
		int sum2 = 0;
		for(int i= 1; i<=10; i++) {
			sum2+=i;
		}
		
		// p.124
		for(int i=1; i<=10; i++) {
			System.out.print(i+" ");
		}
		
		//p.126: 초기값 변수는 for에서 선언 시 지역변수임.
		int sum3 = 0 ;
		for(int 반복변수= 1; 반복변수<=10 ; 반복변수++) {
			sum3+=반복변수;
		}
			//System.out.println(반복변수); // 출력 안됨. for()에서 선언된 변수는 for{}  밖에서 사용 불가
			
		int sum4 = 0; int i;
		for(i =1 ; i<=100; i++) {sum4 += i;}
		System.out.println("1~"+(i-1)+"합: "+sum4);
		
		// p.127 실수	 ☆ 소수점 뒤에 f 사용하는 이유: 직접 작성한 리터럴 일땐 double이 기본형이기 때문에 써줘야됨.
		for(float x= 0.1f; x<=1.0f; x+=0.1f) {
			
		}
		
		
		// 구구단
		for (int k = 2; k <= 9; k++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(k +"x"+ j + "="+j*k+" ");
			}System.out.println();
		}
		
		int a = 1;
		while(a<=10) {System.out.println(a+" ");a++;}
		
		int b = 01;
		int sum5 = 0;
		while (b<=100) {sum5 +=b; b++;}
		
		
		
		Scanner scanner = new Scanner(System.in);
		boolean run = true; // while 켜고 끄고 하는 변수 /true, false 저장
		int speed = 0;
		while (run) {
			
		System.out.println("--------------------------------");	
		System.out.println(" 1. 증속 | 2. 감속 | 3. 중지");// 입력 경우의 수 3가지
		System.out.println("--------------------------------");	
		System.out.println("선택 : ");
		//
		String strNum = scanner.nextLine();
		//-----------------입력에 따른 서로 다른 실행문 처리 [ 조건에 따른 실행 ]
		if (strNum.equals("1")) {// 만약에 입력이 1이면
			speed++; System.out.println("현재 속도 = " + speed);
		}else if (strNum.equals("2")) {// 만약에 입력이 2이면
			speed--; System.out.println("현재 속도 = " + speed);
		}else if (strNum.equals("3")) {// 만약에 입력이 3이면
			run=false;// 1: 조건식을 false 로 만들어서 반복문 종료
			//break; // 2 : 가장 가까운 반복문 탈출
			//return; // 3 : 현재 함수 강제 반환/종료 main 함수 밖으로 이동
			}
		
		
		}//while
		//rum, break 는 여기로 나옴
		
		
	대문자for :for ( char upper = 'A'; upper <= 'Z'; upper++) {
			System.out.print(upper+" ");
	소문자for : for (char lower = 'a'; lower < 'z'; lower++) {
				System.out.print("\t"+lower);
				if (lower =='g') {
					break 대문자for;
				}
			}
			System.out.println();
		}//for 끝
		
		System.out.println();
		// 137p
		
	숫자for:	for (int j = 1; j <=10; j++) {
			if (j % 2 !=0) {
				continue 숫자for; // for 이동 / 아래에 있는 코드 실행x // 홀수 출력x
			}
			System.out.println(j + " ");
		}
		
		
		
		
		
	}//main
	//return 은 여기로 나옴
}//class


/*
 * 		for문
 * 			for(초기값; 조건식; 증감식){
 * 				실행문;
 * 			}
 * 
 * 		1. 초기값 실행
 * 		2. 조건식 판단 : true일 시 {} 실행  / false이면 {}건너뜀(종료)
 * 		3. true 시 실행 문 실행
 * 		4. 초기값이 들어 있는 변수에 증감식
 * 		5. 조건식 판단해서 반복  ( 2->3->4 의 반복)
 * 
 * 		while 문
			1 *초기값
			 while(2.조건식) {3.실행문 4. *증감식}
		
		 * 초기값과 증감식은 필수 값은 아님
		 1. 조건식 판단해서 true 이면 {}들어감, false {} 건너 뜀
		 2. true 면 실행문 실행
		------------ 일반적으로 패턴이 있는경우 for문 사용
		------------ 패턴이 없는경우 코드를 짧게 쓰려고 while 사용
		
		무한루프
		while(true) {sysout(무한루프);}
		for(; ;) {sysout(무한루프);}
		
		
		
		 for 문 여러개 실행시 식별 방법
		 1. for문 식별이름 : for(){}
		 2. break for문 식별이름;  지정한 for 문 탈출
		 	- break -> 가장 가까운 반복문 탈출
		 	- break for문 이름 -> 해당 for문 탈출
		 3. continue;
		 	- 가장 가까운 반복문 증감식/조건식 으로 이동
		 	continue for문 이름 ->
		 	- 해당 for문 증감식/조건식으로 이동
		 	
		
			
		
		
		
		
		
		
 * 
 * 
 * 
 * 
 */
