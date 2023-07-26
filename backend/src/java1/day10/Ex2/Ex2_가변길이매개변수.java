package java1.day10.Ex2;

public class Ex2_가변길이매개변수 {
	public static void main(String[] args) {
		
		
		Computer computer = new Computer();
		int a = computer.sum(1 ,2 ,3, 4, 5);
		System.out.println(a);
		
		System.out.println(computer.sum(1,2,3));
		System.out.println(computer.sum(10,20,30,50,60));

		
		// 배열 전달
		int[] array = { 1 , 2 ,3 ,4 ,5};
		System.out.println(computer.sum(array));
		
		// 배열 전달
		System.out.println(computer.sum(new int [] {1 , 2, 3}));
	}
}
