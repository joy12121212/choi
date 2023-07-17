package 과제.과제2;

import java.util.Scanner;

public class 연산20문제 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	


		//------ 문제1 여기에 풀이-------//
		
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		
		//------ 문제2 여기에 풀이-------//
//		String writer = scanner.next();
//		String content = scanner.next();
//		String date = scanner.next();
		String writer = "유재석";
		String content = "안녕하세요";
		String date = "09-28";
		
		System.out.println(" --------------방문록--------------------");
		System.out.println("| 순번  | 작성자  | 	내용 	| 날짜     |");
		System.out.println("|  1   |"+writer+"\t|"+content+"\t|"+date+"\t|");
		System.out.println("----------------------------------------");

		
		
		//------ 문제3 여기에 풀이-------//
		
			int basic = 1000000;
			int incentive = 500000;
			double tax = basic * 0.1;
			double sum3 = (basic + incentive)-tax;
			int sum33 = (int)sum3;
			
		System.out.println(sum33);		
		
		//------ 문제4 여기에 풀이-------//
		
		int money = 356789;
		
		
		System.out.println("십만원 " + money/100000+"장");
		System.out.println("만원 " +(money % 100000)/10000+"장" ); // 356789 % 100000 은 356789 - 100000 과 같아서 56789 가 남는다 여기서 10000으로 나누면 5
		System.out.println("천원 " +(money % 10000)/1000+"장" );
		System.out.println("백원 " +(money % 1000)/100+"개" );
		
		//------ 문제5 여기에 풀이-------//
		
		int num5 = 21;
		
		System.out.println((num5 % 7 == 0) ? "7의배수":"7의배수가 아니다");
		
		//------ 문제6 여기에 풀이-------//
		
		int num6 = 6;
		
		System.out.println(num6 % 2 == 0 ? "짝" : "홀");
		
		//------ 문제7 여기에 풀이-------//

		int num7 = 42;
		
		System.out.println(num7 % 7 == 0 && num7 % 2 == 0 ? "짝" : "홀" );
		
		//------ 문제8 여기에 풀이-------//

		int num8 = 49;
		System.out.println(num8 % 7 == 0 && num8 % 2 == 1 ? "홀" : "짝" );
	
		//------ 문제9 여기에 풀이-------//
		
		int num9 = 10;
		int num99 = 20;
		
		System.out.println(num9 > num99 ? num9 : num99);
		
		//------ 문제10 여기에 풀이-------//
		
		int num10 = 20;
		System.out.println((num10*num10)*3.14);
		
		//------ 문제11 여기에 풀이-------//
		
		double num11 = 55.54;
		double num111 = 84.5687;
	
		System.out.format("%.6f%%%n" , num11 / num111 * 100.0);
		
		//------ 문제12 여기에 풀이-------//
		
		int num12 = 20; // 윗변
		int num122 = 30; // 밑변
		int num1222 = 10; // 높이
		System.out.println((num12 + num122)*num1222 / 2);
		
		//------ 문제13 여기에 풀이-------//
		
		int num13 = 190;
		
		System.out.println((num13 - 100)*0.9);
		
		//------ 문제14 여기에 풀이-------//
		
		int num14 = 80;
		
		System.out.println(num14 / ((num13 /100)*(num13 /100)));
		
		//------ 문제15 여기에 풀이-------//
	
		int num15 = 4;
		double num155 = num15 * 2.54;
		System.out.println(num155);
	
		//------ 문제16 여기에 풀이-------//
		
		int num16 = 53;
		int num166 = 72;
		int num1666 = 41;
		
		double mid = num16 * 0.3;
		double last = num166 * 0.3;
		double perfor = num1666 * 0.4;
		
		System.out.printf("%.2f " ,mid);
		System.out.printf("%.2f " , last);
		System.out.printf("%.2f " , perfor);
		System.out.println();
		
		//------ 문제17 여기에 풀이-------//
		
			//10 + 5 + 9  이후 x에서 마이너스1 = 23
		
		//------ 문제18 여기에 풀이-------//
		
		int num18 = 1;
		
		System.out.println(num18 >=10 ? num18 >=20 ? num18 >= 40 ? "중년" : "성인" : "학생" : "얼라");
		
		//------ 문제19 여기에 풀이-------//
		
		int kor = 50;
		int eng = 99;
		int mat = 98;
		
		int sum = kor + eng + mat;
		double ave = sum / 3;
		
		System.out.println("총점 "+sum);
		System.out.printf("%.2f " , ave);
		System.out.println();
		//------ 문제20 여기에 풀이-------//
		
		String str1 = "아이디";
		String str2 = "비밀번호1";
		
		System.out.println(str1 == "아이디" && str2 == "비밀번호" ? "로그인성공" : "로그인 실패");
		//------ 문제21 여기에 풀이-------//
		
		int num1 = 100;
		int num2 = 20;
		int num3 = 30;

		System.out.println((num1 > num2) && (num1 > num3) ?  num1 : (num2 > num1) && (num2 > num3) ? num2 : num3); 
		
	}

}


/*

문제1 : 강아지 console 출력
	|\_/|
	|q p|   /}
	( 0 )"""\
	|"^"`    |
	||_/=\\__|

문제2 : 입력받은 3개 데이터를 이용한 표 만들기 
	[입력변수]
		1. 작성자[문자열] , 내용[문자열] , 날짜[문자열] 입력받아 각 변수에 저장 
	[출력 예]
		   --------------방문록--------------------
		   | 순번  | 작성자  | 	내용 	| 날짜       |
		   |  1   | 강호동  |안녕하세요  |  09-28    |
		  ----------------------------------------
	
문제3 : 급여 계산
	[입력조건]
		기본급[정수] , 수당[정수]
	[ 조건 ] 
		 실수령액 = 기본급 + 수당 - 세금[기본급10%] 
	[출력조건] 
		실수령액 출력[ 소수점 없이  ]

문제4 : 지폐 세기 
	 [입력조건 ] 
		금액 
	 [조건 ] 
		 십만원 부터 백원 까지의 개수 세기 
	[ 출력조건 ]
		예) 356789 입력시 
		 십만원 3장 
		 만원 5장
		 천원 6장 
		 백원 7개

문제5 : 하나의 정수를 입력받아 7의 배수인지 출력[ 'O' 혹은 'X' 로 출력]

문제6 : 하나의 정수를 입력받아 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력]

문제7 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제9 : 두개의 정수를 입력받아 더 큰수 출력 

문제10 : 반지름을 입력받아 원 넓이 출력하기 
	계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]

문제11 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기 
	예) 54.5   84.3 실수 2개입력시 결과는   64.285714%

문제12 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 
	계산식) 사다리꼴 계산식 = > (윗변 + 밑변) * 높이 / 2

문제13: 키를 정수를 입력받아 표준체중 출력하기 
	계산식) 표준체중 계산식 = > (키 - 100) * 0.9

문제14: 키와 몸무게를 입력받아 BMI 출력하기 
	계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))

문제15: inch 를 입력받아 cm 로 변환하기 
	계산식) 1 inch -> 2.54cm

문제16:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오 
	계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %

문제17 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
	int x = 10;
	int y = x-- + 5 + --x;
	printf(" x의 값 : %d , y의값 :  %d ", x, y)

문제18 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기

문제19 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력

문제20 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력

문제21 : 세 정수를 입력받아 가장 큰수 출력 

  
 */
