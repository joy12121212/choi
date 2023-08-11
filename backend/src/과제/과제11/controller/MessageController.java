package 과제.과제11.controller;



import 과제.과제11.model.dao.MessageDao;

public class MessageController {
	
	// 싱글톤
	
	// private 객체
	
	private static MessageController controller = new MessageController();
	// 간접 접근 생성자
	public static MessageController getInstance() {return controller;}
	// 외부 객체 생성 제한
	private MessageController() {}
	
	
	
	public boolean MessageSendLogic(int mno , String content) {
		
		boolean result = MessageDao.getInstance().MessageSendSql(MemberController.getInstance().getLoginSession(),mno,content);
			System.out.println(MemberController.getInstance().getLoginSession() + mno + content);
				// MemberController.getInstance().getLoginSession()  == 로그인된 사람 - 발신인 mno
				// mno == 받는 사람 mno  , content == 보낼 내용
		
		return result;
		
	}
	
	
	
	
	
}
