package 과제.과제2.Level1.ex2;

import java.time.LocalDateTime;

public class Level1_2 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_2 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		System.out.printf("%-10s   %15s   %30s\n" , "type" , "value" , "range" );
		System.out.println("-------------------------------------------------------------");
		/* 문제풀이 위치 */
		
		System.out.printf("%-10s   %15s   %30s\n" , "boolean" , "ture" , "ture or false" );
		System.out.printf("%-10s   %15s   %30s\n" , "byte" , "100" , "-128 ~ 127" );
		System.out.printf("%-10s   %15s   %30s\n" , "char" , "A" , "0~65535 [ character 1 ]" );
		System.out.printf("%-10s   %15s   %30s\n" , "short" , "30000" , "-32768 ~ 32767" );
		System.out.printf("%-10s   %15s   %30s\n" , "int" , "2000000000" , "-+2000 million" );
		System.out.printf("%-10s   %15s   %30s\n" , "long" , "40000000000" , "-+2000 million Excess" );
		System.out.printf("%-10s   %15s   %30s\n" , "float" , "3.123" , "8 declmal places" );
		System.out.printf("%-10s   %15s   %30s\n" , "double" , "3.12312312" , "17 decimal places" );
		
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개 선언하고 임의값을 대입하여 출력하시오.
	[조건] 
		1. 모든 기본자료형 8개 사용
		2. printf() 메소드 사용
*/
