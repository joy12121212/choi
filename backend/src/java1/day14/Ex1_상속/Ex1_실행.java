package java1.day14.Ex1_상속;

public class Ex1_실행 {
	public static void main(String[] args) {
		
		// 1. 부모 객체 생성
		phone myphone = new phone();
		
		System.out.println(myphone.color);
		System.out.println(myphone.model);
		//System.out.println(myphone.wifi); // 부모는 자식거 못 쓴다
		
		myphone.bell();
		myphone.sendVoice("여보세요");
		myphone.receiveVoice("안녕하세요 반갑습니다");
		myphone.hangUP();
		//myphone.setwifi(true); // 오류발생/자식꺼
		
		
		// 2. 자식 객체
		smartPhone myphone1 = new smartPhone("갤럭시","은색");
		System.out.println(myphone1.color); // 자식이라 가져다슴
		System.out.println(myphone1.model);
		System.out.println(myphone1.wifi);
		
		
		myphone1.bell();
		myphone1.sendVoice("여보세요");
		myphone1.receiveVoice("안녕하세요 반갑습니다");
		myphone1.hangUP();
		myphone1.setWifi(true);
		myphone1.internet();
		
		 
		
	}//main

}
