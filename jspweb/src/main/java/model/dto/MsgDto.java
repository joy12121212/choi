package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.dao.MemberDao;

public class MsgDto {
	
	private String frommid; // 보낸사람 
	private String msg; 	// 보낸내용
	private String frommimg;// 보낸이미지
	private String date;	// 보낸날짜
	
	
	
	public String getFrommimg() {
		return frommimg;
	}

	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public MsgDto() {}

	public String getFrommid() {
		return frommid;
	}

	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MsgDto(String frommid, String msg) {
		super();
		this.frommid = frommid;
		this.msg = msg;
		// 객체 생성시 추가 코드
			// 1. 보낸 사람의 프로필 가져오기
			MemberDao.getInstance().info(frommid).getMid();
			// 2. 보낸일시 구하기
				// 현재 시간 날짜 구하는 클래스 / new Date() java.util.date
			Date date = new Date(); System.out.println("현재 날짜 시간 : " + date);
				// 날짜 포멧 형식
			SimpleDateFormat sdf = new SimpleDateFormat(" aa hh:mm");
				//y 연도 M월 h시 m분 s초 a 오전,오후
			this.date=sdf.format(date); // 현재 시간을 정의한 형식으로 변환
			
			
	}

	@Override
	public String toString() {
		return "MsgDto [frommid=" + frommid + ", msg=" + msg + ", frommimg=" + frommimg + ", date=" + date + "]";
	}

	public MsgDto(String frommid, String msg, String frommimg, String date) {
		super();
		this.frommid = frommid;
		this.msg = msg;
		this.frommimg = frommimg;
		this.date = date;
	}

	
	

}
