package java2.day23.Ex_3;

public class User2Thread extends Thread{
	
	private calculator calculator;
	
	public User2Thread () {setName("User2");}
	
	public void setCalculator(calculator calculator) {this.calculator = calculator;} // setter 메소드
	
	@Override
	public void run() {
		calculator.setMemory2(50);
	}
	
}
