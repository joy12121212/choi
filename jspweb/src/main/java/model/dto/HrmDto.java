package model.dto;

public class HrmDto {
	
	private int sno;
	private String sname;
	private String sphone;
	private String sposition;
	private String simg;
	private String sdate;
	
	public HrmDto() {
		// TODO Auto-generated constructor stub
	}
	// 풀생성자
	public HrmDto(int sno, String sname, String sphone, String sposition, String simg, String sdate) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sphone = sphone;
		this.sposition = sposition;
		this.simg = simg;
		this.sdate = sdate;
	}	
	//등록 생성자
	public HrmDto(String sname, String sphone, String sposition, String simg) {
		super();
		this.sname = sname;
		this.sphone = sphone;
		this.sposition = sposition;
		this.simg = simg;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSposition() {
		return sposition;
	}
	public void setSposition(String sposition) {
		this.sposition = sposition;
	}
	public String getSimg() {
		return simg;
	}
	public void setSimg(String simg) {
		this.simg = simg;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	@Override
	public String toString() {
		return "HrmDto [sno=" + sno + ", sname=" + sname + ", sphone=" + sphone + ", sposition=" + sposition + ", simg="
				+ simg + ", sdate=" + sdate + "]";
	}
	
	
	

}
