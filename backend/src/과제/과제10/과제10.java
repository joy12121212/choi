package 과제.과제10;

import java.util.Scanner;

public class 과제10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Phone phone = new Phone();
		Battery battery = new Battery();
		App[] app = new App[4];
		

		String appInfo = "유튜브,15 카톡,3 카메라,5 테트리스,20";

		for (int i = 0; i < appInfo.split(" ").length; i++) { // appInfo 를 " " 로 나눈 길이 만큼 for 문 실행
			String _tmp = appInfo.split(" ")[i]; // 임시 변수에 대입하여 코드 길이 절약
			app[i] = new App(_tmp.split(",")[0], Integer.parseInt(_tmp.split(",")[1])); // app i 번째 인덱스에 ","로 나눈 인덱스 값 대입 
		}

		phone.setApp(app); //phone 클래스 setapp에 app 정보 대입
		phone.setBattery(battery); //phone 클래스 setBattery에 battery 정보 대입
		Scanner sc = new Scanner(System.in);
		// -------------------초기화-------------------

		while (true) {
			System.out.println("1. 켜기 2.충전");
			if (sc.nextInt() == 1) {
				while (true) {
					if (phone.getBattery().capacity > 0) {
						for (int i = 0; i < app.length; i++) {
							System.out.printf("%d. %s ", (i + 1), app[i].getName());
						}
						System.out.println("\t 현재 배터리 >> " + phone.getBattery().capacity);
						System.out.print("실행할 앱 선택>> ");
						int ch = sc.nextInt()-1 ;
						if(ch >= app.length) 
						{
							System.out.println("해당 앱이 없습니다.");
							continue;
						}
						
						phone.getBattery().capacityMinus(app[ch].namePrint());
					} else {
						System.out.println("배터리가 없습니다");
						break;
					}
				}

			} else {
				phone.getBattery().capacityPlus();
			}

		}
	}

}
