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
	public boolean signupLogic(String id , String pw , String name , String phone) {
		System.out.println("회원가입로직");
		String signId = id;
		String signPw = pw;
		String signName = name;
		String signPhone = phone;
		
		MemberDto dto = new MemberDto(0, id , pw , name , phone);

		boolean result = MemberDao.getInstance().signupSQL(dto);
//		MemberDao.getInstance()  호출할때 MemberDao 객체가 생성되면서 상속을 받았다면 부모 객체의 기본 생성자가 실행 된다 = db연동		
		
		return result;
		
		
	}
	
	// 2. 로그인 로직
	public boolean loginLogic(String id , String pw) {
		
		String loginId = id;
		String loginPw = pw;
		
	
		boolean result = MemberDao.getInstance().loginSQL(loginId , loginPw);
		return result;
	}

}
