package java1.day11.Ex4디자인패턴2.controller;

import java1.day11.Ex4디자인패턴2.model.dao.MemberDao;
import java1.day11.Ex4디자인패턴2.model.dto.MemberDto;


public class MemberController { // 기능처리 담당 클래스
	
	
	// 1. 객체 생성 [private static ]
	private static MemberController memberController = new MemberController();
	
	// 2. 외부로부터 싱글톤 호출할 수 있도록 get~
	public static MemberController getInstance() {return memberController;}
	// 얘는 간접 나가기라 public
	// 3. 외부에서 객체 생성 차단 // 생성자 잠금 처리
	private MemberController() {}
	
	// 회원정보 저장
	public boolean singupLogic(String id, String pw, String name, String phone, int age) {

		MemberDto m = new MemberDto ( id, pw, name, phone, age);
		
		for (int i = 0; i < MemberDao.memberList.length; i++) {
			if (MemberDao.memberList[i] == null) {
				MemberDao.memberList[i] = m ;return true;

			}//if
		}//for
		return false;
	}//signopLogic

	// 회원정보 비교
	public boolean loginLogic(String id , String pw) {
		for (int i = 0; i < MemberDao.memberList.length; i++) {
			if (MemberDao.memberList[i] != null &&
					MemberDao.memberList[i].getId().equals(id) &&
						MemberDao.memberList[i].getPw().equals(pw)
					) {return true;}//if
		}return false;
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
