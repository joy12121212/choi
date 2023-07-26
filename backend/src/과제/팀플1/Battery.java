package 과제.팀플1;

public class Battery {
	public int capacity = 100;
	
	public void capacityMinus(int batteryDesc) {
		capacity-=batteryDesc; // 100에서 사용량 만큼 - 
		if(capacity <0) {capacity =0;} // capacity 보다 0이 커지면 capacity = 0으로 대입
	}
	
	public void capacityPlus() { // 배터리 충전 
		while(true) {
			capacity+=5; // 5찍 증가
			if(capacity >= 100) { // 100 이상이면 100
				capacity = 100; 
				System.out.println("충전 완료");
				return;
			}
			System.out.println("충전중 : " + capacity + "%");
		}
	}
}
