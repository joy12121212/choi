package java2.day24_제네릭.Ex2;

public class Product<K , M> {
		// 제네릭 : 클래스 안으로 들어오는 파라미터/변수/정해져 있지 않는 타입
		// 제네릭 타입 여러개면 대문자 < A ~ Z > 암거나
		// 장점 : 클래스 설계시 필드에 다양한 타입으로 선언 가능
	
	// 필드
	private K kind;
	private M model;
	
	
	// 생성자	
	public K getKind() {return kind;}
	public void setKind(K kind) {this.kind = kind;}
	public M getModel() {return model;}
	public void setModel(M model) {this.model = model;}

	
	// 메소드

}
