package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {
	
	// 객체 생성
	private static MemberController MemberController = new MemberController();
	
	// 외부 접근 메소드 생성
	public static MemberController getInstance () { return MemberController;}
	
	// 외부 객체 생성 제한
	private MemberController () {}

	
	// 1. 회원가입 로직
	public int signupLogic(String id , String pw , String name , String phone) {
		System.out.println("회원가입로직");
		
		
		// 아이디 중복 체크
		if (MemberDao.getInstance().infoCheck("mid", id)) {return 3;}
		
		// 전화번호 중복 체크		
		if (MemberDao.getInstance().infoCheck("mphone", phone)) { return 4;}

		

		
		MemberDto dto = new MemberDto(0, id , pw , name , phone);

		boolean result = MemberDao.getInstance().signupSQL(dto);
//		MemberDao.getInstance()  호출할때 MemberDao 객체가 생성되면서 상속을 받았다면 부모 객체의 기본 생성자가 실행 된다 = db연동		
		if (result) {
			return 1;
		}else {
			return 2;
		}
		
		
		
	}
	// 로그인 처리
	private int loginSession =0; // 0 로그인 안함 // 1 이상 로그인된 회원의 번호
	public int getLoginSession () {return loginSession;}

	// 로그아웃 처리
	public void logOut() {this.loginSession=0;}
	
	// 2. 로그인 로직
	public boolean loginLogic(String id , String pw) {
		
		System.out.println("로그인 세션 도착");
		int result = MemberDao.getInstance().loginSQL(id , pw);
		
		if (result >=1) {
			this.loginSession = result;
			return true;
		}else {
			return false;
		}
		

	}
	

	
	
	// 3. 아이디 찾기 로직
	
	public String findById( String name , String phone) {
		System.out.println("아이디 찾기 도착");
		
		String findName = name;
		String findPhone = phone;
		
		String result = MemberDao.getInstance().findById(findName, findPhone);

		
		return result;
	}// find id sql
	
	
	//4. 비밀번호 찾기 로직
	public String findByPw(String id , String phone) {
		System.out.println("비밀번호 찾기 도착");
		
		String findId = id;
		String findPhone = phone;
		
		String result =  MemberDao.getInstance().findByPw(findId, findPhone);
		
		
		return result;
	}// find pw sql
	
	// 회원정보 조회
	public MemberDto info() {
		//현재 로그인된 회원 번호가 loginSession 여기에 있으니 view 안들리고 바로 쏨
		return MemberDao.getInstance().info(this.loginSession);
	}	
	
	
	// 비밀번호 수정
	public boolean infoUpdate(String newPw)  {
		
		
		
		
		return MemberDao.getInstance().infoUpdate(newPw, loginSession);
	}
	
	// 회원탈퇴
	public boolean infoDelete() {
		
		
		return MemberDao.getInstance().infoDelete(loginSession);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//mc
