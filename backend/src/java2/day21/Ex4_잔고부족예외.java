package java2.day21;


//예외 클래스 만들기
	// 표준 라이브러리에서 제공하지 않는 라이브러리를 직접 만든다
	// 표준 라이브러리 : 자동완성되는 미리 이클립스 제작자가 만들어놓은거
	// 1. exception 클래스 상속
	public class Ex4_잔고부족예외 extends Exception{ // extends  , RuntimeException
		public Ex4_잔고부족예외 () {}
		
		public Ex4_잔고부족예외(String message) {super(message);}
	

}

