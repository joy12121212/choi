package 과제.팀플1;

import java.util.Scanner;

public class 과제10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Phone phone = new Phone(); // 호출 위해 객체 생성
		Battery battery = new Battery(); // 호출 위해 객체 생성
		App[] app = new App[4]; // 4개 배열 가진 배열 객체 생성

		String appInfo = "유튜브,15 카톡,3 카메라,5 테트리스,20"; // 정보,정보 정보, 정보 --> " " 과 "," 로 구분

		for (int i = 0; i < appInfo.split(" ").length; i++) { // appInfo 를 " " 로 나눈 길이 만큼 for 문 실행
			String _tmp = appInfo.split(" ")[i]; // 임시 변수에 대입하여 코드 길이 절약
			app[i] = new App(_tmp.split(",")[0], Integer.parseInt(_tmp.split(",")[1])); // app i 번째 인덱스에 ","로 나눈 인덱스 값
																						// 대입
		}

		phone.setApp(app); // phone 클래스 setapp에 app 정보 대입
		phone.setBattery(battery); // phone 클래스 setBattery에 battery 정보 대입
		Scanner sc = new Scanner(System.in);
		// -------------------초기화-------------------

		while (true) {

			System.out.println("1. 켜기 2.충전");
			int sc1 = sc.nextInt();
			if (sc1 == 1) { // 입력값이 1 이라면 while 실행
				while (true) {
					if (phone.getBattery().capacity > 0) { // capacity 정보 호출 0 과 비교
						for (int i = 0; i < app.length; i++) { // app 길이 만큼 for 문 실행
							System.out.printf("%d. %s ", (i + 1), app[i].getName()); // i+1 -> i초기값이 0이므로 +1해서 선택한 번호 +
																						// 이름 출력
						}
						System.out.println("\t 현재 배터리 >> " + phone.getBattery().capacity); // 배터리 잔량 출력
						System.out.print("실행할 앱 선택>> ");
						int ch = sc.nextInt() - 1; // 인덱스값을 찾아야되기에 입력값 - 1
						if (ch >= app.length) // 입력값이 배열 길이보다 길다면 아래 메세지 출력 후 while로 이동, 다시 실행
						{
							System.out.println("해당 앱이 없습니다.");
							continue;
						}

						phone.getBattery().capacityMinus(app[ch].namePrint()); // 선택한 앱 출력 및 배터리량 - 함수 실행
					} else { // capacity 값이 0보다 크지 않다면 배터리 충전 위해 break , while 다시 실행
						System.out.println("배터리가 없습니다");
						break;
					}
				} // while

			} else if (sc1 == 2) { // 1번 2번 외에 다른 번호 눌러도 충전이 돼서 if문 추가
				phone.getBattery().capacityPlus(); // 배터리 충전
			} else {
				System.out.println("2번을 눌러 충전을 해주세요");
			}

		} // main while
	}

}
