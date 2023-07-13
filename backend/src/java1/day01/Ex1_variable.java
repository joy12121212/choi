package java1.day01; // 현재 클래스가 위치한 패키지 경로

public class Ex1_variable {//클래스 시작
	public static void main(String[] args) {//메인 시작
		
//		int value;
//		int result = value + 10;//value에 초기값이 없으므로 연산 불가//오류
//		System.out.println(result);
		
		int hour = 3;
		int minute = 5;
		System.out.println(hour + "시간 " + minute + "분");
		
		int totalMinute = (hour*60) + minute;
		System.out.println("총 " + totalMinute + "분");
		
		
	}//메인 끝

}//클래스 끝

// 변수 : 하나의 값을 저장할 수 있는 메모리 주소에 붙여진 이름
// 형태 : 타입 변수명;		: 단순 선연 
//		타입 변수명 = 초기값;	: 선언과 동시에 초기값 저장
// 타입 : 미리 정해진 변수의 크기
// 변수명 : 메모리 주소 대신에 식별용으로 사용되는 메모리 이름
// = : 할당 연산자 / 오른쪽 값을 왼쪽에 저장