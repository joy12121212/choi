package java1.day06;

public class Ex2_확인문제 {

	public static void main(String[] args) {
		
		int count = 0; // 모든 경우의수 if { } 에서 공유하기 위해 if { } 밖에서 선언 
		int[] scores = new int[count]; //  // 모든 경우의수 if { } 에서 공유하기 위해 if { } 밖에서 선언 
		
		// [p.199] 확인문제 9
		while(true) { // while s // 무한루프 
			System.out.println("-----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료 ");
			System.out.println("-----------------------------------------------");
			System.out.print("선택> ");
		
			
			
			
			
		
		
		}//while 
	}//main
}


/*
	step4
	설계조건
		- 학생수를 입력받아 입력받은 학생수 만큼 점수를 입력받아 저장 
		- 현재 점수 출력 / 통계 
		
		1.학생수
			- 학생수를 입력받아 '학생수' 변수에 저장한다.
			- 그 학생수 만큼 배열 선언한다.[ 메모리 할당 ]  : 타입[] 변수명 = new 타입[길이]
		2.점수입력
			- 몇개 점수 입력?????????? 정해져 있지 않는 상태 --> 변수로만 처리 비효울적으로 --> 배열 효율적
			- 1번기능에서 할당된 배열만큼 점수를 입력받아 각 인덱스에 저장한다.
				[ 만일 학생수를 입력받지 않고 점수입력을 하면 오류 발생!!! ]
		3.점수리스트
			- 2번기능에서 저장된 배열내 모든 인덱스 데이터 호출 한다. 
		4.분석
			- 2번기능에서 저장된 배열내 모든 인덱스 데이터를 모두 더한후 학생수 만큼 나눈다. = sum/학생수(1번기능)
			- 2번기능에서 저장된 배열내 모든 인덱스 데이터를 호출해서 최고점수 찾는다 = max
		5.종료 
			무한루프 종료해서 출력그만!!! break;
			
			
	// .nextLine() 사용시 주의할점 
	 	* nextLine 사용시 다른 next~~() 앞뒤로 존재 했을때 하나로 인식 [ 오류 처럼 보일수 있다 ].
	 	1. 해결 방안1
	 	 	Integer.parseInt( scanner.nextLine() );
	 	2. 해결 방안2
	 		String 문자 = scanner.nextLine();
	 		int 정수 = scanner.nextInt()
	 		
	 		scanner.nextLine(); !!!! 의미 없는 nexLine() 추가해서 
	 		
	 		String 문자 = scanner.nextLine();
	 	 
		
*/