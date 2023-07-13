package java1.day01;

import java.util.Scanner;

public class Ex4_input_output {
	public static void main(String[] args) {
		
		
		// 1. 출력
			// System.err.print();		// 붙여서 계속 출력
		System.out.print("출력문구1");
		System.out.print("출력문구2");
			// System.err.println();	// 출력하고 줄 바꿈
		System.out.println("출력문구3");
		System.out.println("출력문구4");
			// System.err.printf();		// 형식문자열에 맞춰서 값 출력
			// %d 정수 , %f 실수 , %s 문자열 , %자리수d 오른쪽 정렬 , %-자리수d 왼쪽 정렬 , %0자리수 공백 0으로 채우기
		int value = 123;
		System.out.printf("상품의 가격 : %d원 \n", value); //%d 자리에 value 값 출력
		System.out.printf("상품의 가격 : %6d원 \n", value); // 6칸 정수 자리에 value 변수 출력
		System.out.printf("상품의 가격 : %-6d원 \n", value); // 6칸 정수 자리에 value 변수 출력 
		System.out.printf("상품의 가격 : %06d원 \n", value); // 6칸 정수 자리에 value 변수 출력 

		System.out.printf("반지름 파이  %f \n", 3.14); // 
		System.out.printf("반지름 파이  %.1f \n", 3.14); // 
		
		// 2. 입력
			// 1. 입력 객체 생성한다.
			// new 연산자 : 객체에 메모리 할당/생성
			// scanner () : 클래스 생성자 (객체 생성시 초기값 대입하는 메소드) = 클래스명 무조건 같음
			// System.in = 키보드로 입력 // System.out = 콘솔창
			
		Scanner scanner = new Scanner(System.in);

		String str1 = scanner.next(); // scanner.nextLine(); : 띄어쓰기 입력 받을 수 있음
		System.out.println("입력한 문자열은 "+ str1);
		
		boolean ft = scanner.nextBoolean();
		System.out.println("입력된 논리는 " + ft);
		
		byte bt = scanner.nextByte();
		System.out.println("입력된 바이트는 " + bt);
		
		int in = scanner.nextInt();
		System.out.println("입력된 인트는 " + in);
		
		
		
	}
}
