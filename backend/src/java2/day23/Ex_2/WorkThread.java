package java2.day23.Ex_2;

public class WorkThread extends Thread {
	
	
	// 필드
	public boolean work = true;//스레드 상태에 사용되는 스위치 변수[on//off]
	
	//생성자
	public WorkThread(String Name) {super.setName(Name);}
	//Thread.currentThread().setName();
	
	//메소드
	@Override
	public void run() {
		while (true) {
			if (work) {
				System.out.println(super.getName());
			}//super.getName() Thread 부모꺼에서 가져온거임
			//super.getName() 이거는 부모꺼 갖다씅께 내부에서쓰는거라 super 생략 가능
			else {
				Thread.yield();// 현재 스레드의 양보
			}
		
		}//while 무한루프
	}
		
	
	
}
