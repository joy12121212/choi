package java1.day10.Ex3;

public class Car {
	//1. 필드
	int gas; // 현재 객체의 gas 데이터를 저장하는 곳
	
	
	//3. 메소드
		//1. 필드에 저장하는 용도의 함수는 set 필드명
		//2. 필드에 값을 호출하는 용도의 함수는 get 필드명 -> setter / getter
		//3. 필드에 값 존재여부(boolean) 확인하는 함수 is 필드명
	
	
	// 리턴 x 매개변수 x
	void setGas(int gas) { // 리턴x , 입력받은 int gas 값을 gas 필드에 저장하는 메소드
		this.gas = gas;
		//this : 현재 객체[누구인지 지정 해준다] // 매개변수와 필드 변수가 같을때 구분하려고]
	}

	// 리턴 o 매개변수 x
	boolean isleftGas() {
		if (this.gas == 0) {
			System.out.println("가스가 없습니다");
			return false;
		}
		System.out.println("가스가 있습니다");
		return true;
	}//bool
	
	// 리턴x 매개변수x
	
	void run () { // 가스가 0이 될때까지 무한루프 // 가스가 0이 될때까지 1씩 차감
		while (true) {
			if (this.gas > 0) {
				System.out.println("달립니다.가스잔량 : " + this.gas);
				this.gas--;
			}//if
			else {
				System.out.println("멈춥니다.가스 잔량 : " + this.gas);
				return;
			}//else
		}//while
		
	}//run
	
	
}//class
