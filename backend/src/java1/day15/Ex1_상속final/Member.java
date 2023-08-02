package java1.day15.Ex1_상속final;

//public final class Member {
public class Member{
	
	/*

		final 키워드 -> 최종적, 수정 불가능한 상태로 만드는 키워드
			- 필드 : 수정 불가능한 필드
				ex) final int 나이 = 30;
			- 클래스 : 상속 불가능
				final class Member{} : 해당 클래스는 상속불가
				class Member{}		 : 해당 클래스는 상속 가능
			- 메소드 : 오버라이딩 불가능
				final void stop(){}	 : 해당 메소드는 자식 클래스가 오버라이딩 할 수 없음
		
		접근 제한자
			public			vs			private
			- 모든(클래스) 범위				- 현(클래스) 범위
			- 프로테긑내 모든곳 호출			- 현재 클래스에서만 호출
			
			default			vs			protected
			- 현 크랠스의 패키지 내			- 현재 클래스의 패키지 내
			- 무조건 동일/하위 패키지 내		- 동일 패키지 내 / 하위패키지
			- 생략						- 자식 클래스가 다른 패키지에 있는 부모클래스를 호출 가능
				
				
				
				
	*/
	
	public  void stop1() {}		//: 오버라이딩 불가능한 메소드
	public final void stop2() {}		//: 오버라이딩 불가능한 메소드
	
	
	
	
}
