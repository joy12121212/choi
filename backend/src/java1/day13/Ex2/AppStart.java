package java1.day13.Ex2;

import java1.day13.Ex2.view.MainPage;

public class AppStart {
	// 여기서 모든게 시작된다 // main 만들어 놓는다
	public static void main(String[] args) {
		
//		MainPage mainPage = new MainPage();
//		mainPage.mainPage(); // 객체 만들어서 메소드 호출
//		
//		MainPage.mainPage(); // static 일때
		
		MainPage.getInstance().mainPage(); // private 이라면 getInstance 사용 간접호출
		
	}

	
}
