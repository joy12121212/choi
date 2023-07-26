package java1.day10.Ex4;

public class Ex4_메소드 {
	public static void main(String[] args) {
		
		//------------ 메소드 사용/호출 -----------------
		// 1. 객체 생성
		Member m = new Member();
		// 2. 객체내 도트연산자 이용한 필드 메소드 호출
		
		// 깡통
		m.signUp();
		// 매개변수 2개
		m.login("qwe", 1);
		// 리턴o 매개변수x
		m.findId(); // 값을 리턴 받긴 했지만 쓸데 없음
		String result1 =  m.findId();
		String result2 = m.findId(); // 값을 리턴 받고 사용하려고 변수에 저장
		//리턴o , 매개변수 o
		String[] result3 = m.findPw("aa", "bb");
		
		m.delete("ㅎㅇ" , " ㅋㅋ", "ㅇㅇㅇ");
		m.delete(1, "dd" , "zzz" , "asdf");
		
	}


}
