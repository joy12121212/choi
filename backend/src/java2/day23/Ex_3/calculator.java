package java2.day23.Ex_3;

public class calculator {
	
	private int memory;

	public int getMemory() {return memory;}
	
//	public void setMemory1(int memory) {
	public synchronized void setMemory1(int memory) {
		// 매개변수로 들어온 값을 memory에 저장
		this.memory = memory; 
		// 현재 스레드에 2초간 일시 정지
		try {Thread.sleep(2000);} catch (Exception e) {} 
		// 필드값 확인
		System.out.println(Thread.currentThread().getName() + " 요청한 2초 후 저장된 메모리 : "+ this.memory);
		
	}//setmemory1
	
	
	// 특정 구역만 동기화  synchronized (this)
	public void setMemory2(int memory) {
		
		System.out.println("비동기화 구역");
		
		synchronized (this) {
			System.out.println("동기화 구역");
			this.memory = memory;
			try {Thread.sleep(2000);} catch (Exception e) {	}
			System.out.println(Thread.currentThread().getName() + " 요청한 2초 후 저장된 메모리 : "+ this.memory);
		}
		
		
		
	}//setmemory2
	
}//class
