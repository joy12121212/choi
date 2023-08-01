package java1.day14.Ex3_부모메소드호출;

public class Ex3_실행 {
	public static void main(String[] args) {
		
		SupersocinAirplane supersocinAirplane = new SupersocinAirplane();
		supersocinAirplane.hashCode();
		
		supersocinAirplane.takeOff();
		supersocinAirplane.hashCode();
		supersocinAirplane.fly();
		supersocinAirplane.toString();
		
		//규모가 큰 프로젝트를 할때 상속을 사용하면 간소화
		// 최상위 클래스 == object 
	}

}
