package java1.day10.Ex2;

public class Computer {
	
		// 1 . 가변길이 매개변수를 갖는 메소드 선언 // 파라미터 몇개 넣을지 안 정해져있음/맘대로 넣으삼
		// 2 . 가변길이와 일반 매개변수를 같이 사용할 경우 가변길이매개변수를 일반 매개변수 뒤로 둬야 함

	
	// int sum (String a , int ... value){ 이렇게 뒤에 두고 사용 한다}

	int sum (int ... value) {
			// 타입 ... 배열변수명(ex)value) [자동으로 배열로 만들어서 대입 한다]
		int sum = 0; // 매개변수로 들어온 여러개의 변수를 더한 변수
		
		for (int i = 0; i < value.length; i++) {
			sum += value[i];
		}
		return sum;
		
	}  
}	
