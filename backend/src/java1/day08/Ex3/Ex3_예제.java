package java1.day08.Ex3;

// 현 클래스의 사용 목적 : 실행
public class Ex3_예제 {
	public static void main(String[] args) {
		
		// 1 . 객체의 선언은 : 클래스명 변수명 = new 생성자명();생성자를 정의하지 않으면 기본 생성자();
		 car myCar = new car(); // 힙 영역에 주소를 만들고 myCar 에 주소값을 대입
		 	// car : 정의한 클래스/설계도
		 	// myCar : 반환된 객체의 주소를 가지고있는 지역 변수
		 	// = new : 힙영역에 객체를 생성 후 힙주소를 지역변수에 반환
		 	// car() : 생성자 - 클래스명과 동일
		 
		 
		 
		// 2. 객체의 필드 호출
		 	// .도트연산자 : 변수명.필드명;	// 해당 변수가 가지고있는 객체의 주소로 이동해서 필드 호출
		 
		 System.out.println("모델명 : " + myCar.model); 
		 // myCar 변수 안에 car 클래스의 주소가 저장됨 // car에서 model 이라는 변수를 호출해서 그 값을 가져온다
		 System.out.println("시동여부 : " + myCar.start);
		 System.out.println("현재속도 : " + myCar.speed);
		 
		 
		 
		 
		 
		 
		 
	}

}
