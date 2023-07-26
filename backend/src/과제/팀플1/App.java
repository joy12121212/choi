package 과제.팀플1;

public class App {
	
	private String name;
	private int batteryDesc;
	
	public App(String name, int batteryDesc) { // 메인에서 app 으로 setApp 으로 정보 전달 // name , batteryDesc 필드값 대입
		this.name = name; 
		this.batteryDesc = batteryDesc;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	public int namePrint() {//선택한 앱 정보 노출 // batteryDesc 값 리턴 = 배터리 사용량
		System.out.println(name + "선택 됨");
		return batteryDesc;
	}
}
