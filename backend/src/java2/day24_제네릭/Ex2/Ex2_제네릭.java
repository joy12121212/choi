package java2.day24_제네릭.Ex2;

public class Ex2_제네릭 {
	
	public static void main(String[] args) {
		
		// Product 객체를 tv를 가지고 만든다
		Product<Tv, String> product1 = new Product<>();
			// product 객체에 [ Tv kind = null; , String model = null; ] 이렇게 된다
		product1.setKind(new Tv());		// Tv kind = new Tv();
		product1.setModel("스마트TV");	// String model = "스마트TV";
		
		Tv tv = product1.getKind();
		String tvmodel = product1.getModel();
		System.out.println(tv +" 띄고 " +tvmodel);
		
		// 다른 타입의 제네릭 객체를 또 만들고 싶으면(제네릭을 변경하고 싶으면) 다시 객체를 생성 해야 된다
		// 바뀌치기가 안돼 // 변수에 데이터값 바꾸듯이 안돼
		
		// Product 객체를 car를 가지고 만든다
		Product<Car, String> product2 = new Product<>();
		product2.setKind(new Car());
		product2.setModel("SUV");
		
		Car car = product2.getKind();
		String str = product2.getModel();
		
		
		
		
	}
}
