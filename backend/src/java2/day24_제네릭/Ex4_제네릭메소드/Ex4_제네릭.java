package java2.day24_제네릭.Ex4_제네릭메소드;

public class Ex4_제네릭 {
	
	// 제네릭 메소드 선언
		// 메소드 선언부에 <제네릭타입> : 함수내에서도 제네릭 타입 사용할 수 있다.
	public static <T> Box<T> boxing (T t) {
		// <T> = 제네릭 타입 / (참조타입or기본타입)Box<T> = 리턴타입 / boxing = 메소드명 / ( T(타입) t(값) ) = 파라미터
		// T t = 100; // object 타입 기본값
		// 활용성은 좋지만 가독성이 떨어진다 // 주석을 잘 달아라 // 누가봐도 알 수 있도록
		
		Box<T> box = new Box<>();
		box.setT(t);
		return box;
		
		
	}
	
	
	// 메인 메소드
	public static void main(String[] args) {
		
		// 1. Box 객체 t필드 Integer 타입으로 선정
		Box<Integer> box1 = boxing(100); // 넣는 값에 따라서 (자동으로) 타입이 대체 된다
			// box1 [ Integer t ]
		int intvalue = box1.getT();
		System.out.println(intvalue);
		
		// 2. Box 객체 t필드 Integer 타입으로 선정
		Box<String> box2 = boxing("안녕하세요"); // 넣는 값에 따라서 (자동으로) 타입이 대체 된다
			// box1 [ Integer t ]
		String intvalue1 = box2.getT();
		System.out.println(intvalue1);
		
		// boolean ?
		Box<Boolean> box3 = boxing(true); // 넣는 값에 따라서 (자동으로) 타입이 대체 된다
			// box1 [ Integer t ]
		boolean intvalue2 = box3.getT();
		System.out.println(intvalue2);
		
		// double ?
		Box<Double> box4 = boxing(10.15715); // 넣는 값에 따라서 (자동으로) 타입이 대체 된다
		// box1 [ Integer t ]
		double intvalue3 = box4.getT();
		System.out.println(intvalue3);
		
		
		// ArrayList : 누군가 미리 만든 클래스[라이브러리]
			// 라이브러리[클래스] < API[인터페이스 포함] < 프로그램제공[프레임워크]
		
		
		
	}

}
