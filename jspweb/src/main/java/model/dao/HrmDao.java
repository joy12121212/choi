package model.dao;

import java.util.ArrayList;

import model.dto.HrmDto;

public class HrmDao extends Dao{
	private static HrmDao hrmDao = new HrmDao();
	public static HrmDao getInstance() {return hrmDao;}
	private HrmDao() {}
	
	
	public boolean signup(HrmDto dto) {
		
		try {
			String sql = "insert into hrm (sname , sphone , sposition , simg) values (? , ? , ? , ?);";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getSname());
			ps.setString(2, dto.getSphone());
			ps.setString(3, dto.getSposition());
			ps.setString(4, dto.getSimg());
			
			int row = ps.executeUpdate();
			
			if (row == 1) {
				return true;
			}return false;
			
		} catch (Exception e) {System.out.println("직원등록 에러 : " + e);}
		
		return false;
	}
	
	
	public ArrayList<HrmDto> sRead(){
		ArrayList<HrmDto> list = new ArrayList<>();
		
		try { 
			String sql = "";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				HrmDto hrmDto = new HrmDto(
				rs.getInt(1), rs.getString(2), rs.getString(3),
				rs.getString(4), rs.getString(5), rs.getString(6));
			list.add(hrmDto);
			
			}
			
		} catch (Exception e) {
			System.out.println("sread 오류 발생 : " + e);
		}return list;
		
	}

}
