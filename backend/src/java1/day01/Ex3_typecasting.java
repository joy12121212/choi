package java1.day01;

public class Ex3_typecasting {
	public static void main(String[] args) {
		
		//1. 자동 타입 변환 : 바이트 > 쇼트 > 인트 > 롱 > 플롯 > 더블
		byte b1 = 10;
		int i1 = b1;

		char c1 = '가';
		i1 = c1;

		int i2 = 50; long l1 = i2; 
		long l2 = 100; float f1 = l2;
		
		float f2 = 10.5f; double d1 = f2;
		
		//2. 강제 타입 변환 : 거꾸로 // (작은 타입 자료형) 데이터 ;
		
		int i3 = 10 ; byte b2 = (byte)i3;
		long l3 = 300; int i4 = (int)l3;
		int i5 = 65; char c2 = (char)i5;
		double d3 = 3.14; int i6 = (int)d3;

	}

}


// 타입/자료형 변환
// 1. 자동 타입 변환 -> 사이즈 작은애를 큰걸로 변환 - 자동 / 할거 없음
// 2. 강제 타입 변환 -> 사이즈 큰 애를 작은애로 변환 - 수동 / 데이터 손실 발생할 수 있음 / ( 캐스팅 ) ex) (int)
// 3. 연산시 자동 타입 변환 -> 피연사자 중 큰 타입을 결과 타입으로 변환 시킨다.
// 단 정수는 int 보다 작은 byte ,short는 무조건 인트 결과가 나옴
// int 보다 큰 허용범위 long 연산시 long 으로 결과가 나옴

// ★ 4. 문자열 -> 기본타입으로 변경 ★★★★★★★★★★★★★★★ 매우 매우 중요 하다 
//				- 외부에서 데이터가 문자로 들어오는 경우가 다수다 [ js -> java ] 서로 다른 문법을 사용 한다
//				"10" : 문자(10)   !=   10 : 정수(10)
//				기본타입 : int
//					int 정수 = 10 ; -> 정수.???
//				기본타입 class : Integer
//					Integer 정수 = 10 ;   정수.메소드()
//				
//				Byte.parseByte()/Short.parseShort()/Integer.parseInteger()
//		기본타입 -> 문자열로 변경
//			1. String.valueOf()  String.vlaueOf(10) -> 10 을 "10"으로 변경
//			2. 10 + "" -> 10을 "10"으로 변경
//
