package java1.day02; // 현재 클래스의 패키지 경로

public class Ex2_연산자 { // class 
	public static void main(String[] args) {
		
		int x = +10; int y = -10;
		
		System.out.println("x" + x);
		System.out.println("y" + y);

		//1. 산술 연산자
		System.out.println("x+y = " + (x+y));
		System.out.println("x-y = " + (x-y));
		System.out.println("x*y = " + (x*y));
		System.out.println("x/3 = " + (x/3));
		System.out.println("x%3 = " + (x%3));
		
		//2. 비교 연산자
		System.out.println("x == y " + (x==y));
		System.out.println("x != y " + (x!=y));
		System.out.println("x > y " + (x>y));
		System.out.println("x < y " + (x<y));
		System.out.println("x >= y " + (x>=y));
		System.out.println("x <= y " + (x<=y));

		//3. 논리 연산자
		System.out.println("x >= 10 nad y >= 10 : " + (x>= 10 && y>=10));
		System.out.println("x >= 10 or y >= 10 : " + (x>= 10 || y>=10));
		System.out.println("부정 : " + (!true));
		
		//4. 대입 연산자
		int a = 30; // 대입 연산자
		a += x; // a = a + x; [누적 시킬때]
			System.out.println(a);
		// a *= x; , a -= x; , a /= x; , a %= x;
		
		//5. 삼항 연산자
			// 조건 ? 조건 ? 참 : 거짓
			// 조건 ? 참 : 조건 ? 참 : 거짓
		String result = ( x>= 20 ) ? "합격" : "불합격";
			System.out.println(result);
		String result2 = (x >= 11 ) ? "1차 합격" : (y >= 10) ? "2차 합격" : "최종탈락"	;
			System.out.println(result2);
			
		//6. 증감 연산자	
		System.out.println("++ x : " + (++x));
		System.out.println("x++ : " + (x++));
		System.out.println("x : " + x);
		//마이너스도 동일
			
		//7.연결 연산자
		System.out.println(3 + 3); // 더하기
		System.out.println("연결" + 3 + 3); //문자가 한개라도 끼면 다 문자 () 쳐줘야 구분됨
		System.out.println("연결" + (3 + 3)); //문자가 한개라도 끼면 다 문자 () 쳐줘야 구분됨
		System.out.println(3+""+3);//문자로 바꿔줌
 			
			
			
		
	}//main
}//class
