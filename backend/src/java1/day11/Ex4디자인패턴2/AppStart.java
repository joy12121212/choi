package java1.day11.Ex4디자인패턴2;

import java1.day11.Ex4디자인패턴2.view.MainPage;

public class AppStart {
	public static void main(String[] args) {
		//다른 클래스에 있는 매소드를 호출하는 방법
		// 1. 인스턴스 멤버이면 객체 만들어서 호출
		MainPage mainPage = new MainPage();
		mainPage.mainPage();
		// 2. 정적 멤버이면 클래스를 통해서 호출
		//MainPage.mainPage();  이거 오류 임포트 안되어있음
		// 3. 싱글톤 객체이면 싱긑톤 객체 호출-매소드 호출
		
		
	}

}
