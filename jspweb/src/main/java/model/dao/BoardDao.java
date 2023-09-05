package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao {

		private static BoardDao boardDao = new BoardDao();
		public static BoardDao getInstance() {return boardDao;}
		private BoardDao () {}
		
		
	// 1 글쓰기
	public boolean bwrite(BoardDto dto) {
			
			String sql = "insert into board (btitle , bcontent , bfile , mno , bcno) values ( ? , ? , ? , ? ,?);";
		try {	
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getMno());
			ps.setInt(5, dto.getBcno());
		
			int row = ps.executeUpdate();
			
			if (row==1) {return true;}
		}catch (Exception e) {System.out.println("글쓰기 다오 bwrite 오류야!! : " +  e);}
		return false;
			
	}
	
	
	// 2-2 게시물 수 출력
	
	public int getTotalSize(int bcno) {
		
		try {
			String sql = "select count(*) from board b";
			
			if (bcno !=0) {// 만약에 전체보기가 아니라면 개별 카테고리 조회
				sql += " where b.bcno = " + bcno;
			}
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs.next()) {return rs.getInt(1);}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}
	
	
	
		
		// 2 모든글 출력
	public ArrayList<BoardDto> blistAll( int bcno,int listsize , int startrow){
		
		ArrayList<BoardDto> list = new ArrayList<>();
		
			try {
				String sql = "select b.* , m.mid , m.mimg , bc.bcname from board b natural join bcategory bc natural join member m ";
				//만약에 카테고리가 0(전체보기)가 아니면
				if (bcno != 0) {sql += " where b.bcno = " + bcno;}
				
				// 뒤부분 공통 sql
				sql +=" order by b.bdate desc limit ? , ?";
				
				ps = conn.prepareStatement(sql);
				ps.setInt(1, startrow);
				ps.setInt(2, listsize);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					BoardDto dto = new BoardDto(
						rs.getInt("bno"),rs.getString("btitle"),rs.getString("bcontent"),
						rs.getString("bfile"),rs.getString("bdate"),
						rs.getInt("bview"),rs.getInt("mno"),rs.getInt("bcno"),
						rs.getString("mid"),rs.getString("bcname"),rs.getString("mimg")
					);
					list.add(dto);
				}
			} catch (Exception e) {System.out.println("보드다오 blistAll 에러 : " + e);}
		return list;
		
	}
	
		// 3 개별 글 출력
	public BoardDto getBoard(int bno) {
		viewIncre(bno);
		try {
			String sql = "select b.* , m.mid , m.mimg ,bc.bcname\r\n"
					+ "from board b \r\n"
					+ "natural join member m\r\n"
					+ "natural join bcategory bc\r\n"
					+ "where b.bno = ?;";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt("bno"),rs.getString("btitle"),rs.getString("bcontent"),
						rs.getString("bfile"),rs.getString("bdate"),
						rs.getInt("bview"),rs.getInt("mno"),rs.getInt("bcno"),
						rs.getString("mid"),rs.getString("bcname"),rs.getString("mimg")
					);
				return dto;
			}
		} catch (Exception e) {System.out.println("보드다오 개별글 출력 에러 : " + e);}
		return null;
	}
	
	
	
		// 4 게시물 수정
		
	public boolean onUpdate(BoardDto dto) {
		
		String sql = "update board set btitle = ? , bcontent = ? , bfile = ? , bcno = ? where bno = ?;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getBcno());
			ps.setInt(5, dto.getBno());
			
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
			
		} catch (Exception e) {
			System.out.println("다오 게시물수정 오류 : " +e);
		}
		return false;
	}
	
	
		// 5 게시물 삭제
		
	public boolean ondelete(int bno) {
		
		String Sql = "delete from board where bno = ?";
		try {
			ps=conn.prepareStatement(Sql);
			ps.setInt(1, bno);
			int count = ps.executeUpdate();
			if (count == 1) {return true;}
		} catch (Exception e) {System.out.println("다오글삭제 오류 : " +e);}
		return false;
	}
	
	
		// 6 조회수 증가
		
	
	// 조회수 증가 함수 만들어놓고 증가할 타이밍 / 언제 증가 시킬건지 / 거기다 낑가 넣으면 됨
	public boolean viewIncre(int bno) {
		
		try {
			String sql = "update board set bview = bview+1 where bno = ?;";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int count = ps.executeUpdate();
			
			if (count == 1) {return true;}
		} catch (Exception e) {System.out.println("보드다오 조회수증가 오류 : " +  e);}
		return false;
	}
		
		
}//dao
