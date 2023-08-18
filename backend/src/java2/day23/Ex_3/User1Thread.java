package java2.day23.Ex_3;



public class User1Thread extends Thread{
	
	private calculator calculator;
	
	public User1Thread () {setName("User1");}
	
	public void setCalculator(calculator calculator) {this.calculator = calculator;} // setter 메소드
	
	@Override
	public void run() {
		calculator.setMemory1(100);
	}
	

}
