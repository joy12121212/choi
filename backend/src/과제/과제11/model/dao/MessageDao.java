package 과제.과제11.model.dao;



public class MessageDao extends Dao {
	
	//싱글톤
	
	//private 객체
	private static MessageDao messageDao = new MessageDao();
	//간접 접근
	public static MessageDao getInstance() {return messageDao;}
	//외부 객체 생성 제한
	private MessageDao() {}
	
	
	
	public boolean MessageSendSql(int sender , int taker, String content) {

		String sql = "insert into message(psender , ptaker , pcontent) values(? , ? , ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sender);
			ps.setInt(2, taker);
			ps.setString(3, content);
			int row= ps.executeUpdate();
			
			if (row ==1) {return true;}
		} catch (Exception e) {
			System.out.println("에러"+e);
		}return false;
	}
	
	

}
