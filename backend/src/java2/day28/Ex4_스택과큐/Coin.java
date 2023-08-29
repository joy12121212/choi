package java2.day28.Ex4_스택과큐;

public class Coin {
	private int value;
	public int getValue() {return value;}
	public void setValue(int value) {this.value = value;}
	public Coin(int value) {
		super();
		this.value = value;
	}
	@Override
	public String toString() {
		return "Coin [value=" + value + "]";
	}
	
	
}
