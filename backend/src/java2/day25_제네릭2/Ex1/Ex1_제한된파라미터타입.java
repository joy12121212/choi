package java2.day25_제네릭2.Ex1;

public class Ex1_제한된파라미터타입 {
	
			// 얘는 Number 랑 Number 의 자식클래스들만 파라미터에 접근할 수 있다
	public static <T extends Number> boolean compare(T t1 , T t2) {
		
		System.out.println(t1.getClass().getSimpleName());  //getClass().getSimpleName()  클래스 이름 가져오기
		System.out.println(t2.getClass().getSimpleName());
		

		
		
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return (v1==v2);
	}
	
	public static void main(String[] args) {
		
		// p 582
		
		boolean result1 = compare(10 , 20); System.out.println(result1);
		boolean result2 = compare(4.5 , 5.5); System.out.println(result2);
		//String result3 = compare("안녕하세요","하이"); System.out.println(result2);   얘는 오류 뜸 // Number 랑 관련이 없어서
		Integer i = 3;		// Integer 클래스는 Number 자손
		Double d = 3.0;		// 얘도
		String s = "a";		// 얘는 아님 // 지꺼

		
	}

}




/*

	제네릭 : 결정되지 않은 타입을 파라미터로 처리하고 실제 사용할때 파라미터를 구체적인 타입으로 대체 < >
		1. < > : 파라미터 이름은 알파벳 대문자 A ~ Z까지 사용 권장
		2. 사용처
			1. 클래스 : public class 클래스명 < ? >  {}
				-- 1. 클래스 정의시
				public class 클래스명 < ? >  {
					T t;  정의 한다
				}
				-- 2. 객체 생성시
				클래스명 < 구체적인 타입 > 객체명 = new 생성자 <>();
								
			2. 메소드 public < > 리턴타입 메소드명 ( ) {}
				
				-- 1. 메소드 정의
				public < T > int 메소드명(T t) {
					int vlaue = t;
					return value;
				}
				
				-- 2. 메소드 호출
				메소드명(100);
	








*/