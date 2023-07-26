package 과제.과제10;

public class Phone {
	private App[] app;
	private Battery battery;

	public App[] getApp() {
		return app;
	}

	public void setApp(App[] app) {// 메인 클래스에서 앱 정보 호출 후 필드 대입
		this.app = app;
	}

	public Battery getBattery() {
		return battery;
	}

	public void setBattery(Battery battery) {// 메인 클래스에서 배터리 정보 호출 후 필드 대입
		this.battery = battery;
	}

}
