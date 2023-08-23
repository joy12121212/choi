package java2.day24_제네릭.Ex3;

public class Ex3_제네릭 {
	public static void main(String[] args) {
		
		// 1. 홈 렌탈 구현체
		HomeAgency 안산지점 = new HomeAgency();
		
		Home 우리집 = 안산지점.rent();
		우리집.turnOnligth();
		
		Home 너네집 = 안산지점.rent();
		너네집.turnOnligth();
		
		
		HomeAgency 의왕지점 = new HomeAgency();
		
		Home 병철집 = 의왕지점.rent();
		병철집.turnOnligth();
		
		Home 소영집 = 의왕지점.rent();
		소영집.turnOnligth();
		
		// 확장성 좋다
		
		
		// 2. 자동차 렌탈 구현체
		
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
		
		
	}

}
