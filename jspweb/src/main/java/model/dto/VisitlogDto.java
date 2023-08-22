package model.dto;

public class VisitlogDto {

	private int vno;
	private String writer;
	private String pw;
	private String content;
	private String date;
	
	public VisitlogDto() {
		// TODO Auto-generated constructor stub
	}
	
	public VisitlogDto(int vno, String writer, String pw, String content, String date) {
		super();
		this.vno = vno;
		this.writer = writer;
		this.pw = pw;
		this.content = content;
		this.date = date;
	}
	
	public VisitlogDto(String writer, String pw, String content) {
		super();
		this.writer = writer;
		this.pw = pw;
		this.content = content;
	}
	
	public int getVno() {
		return vno;
	}
	public void setVno(int vno) {
		this.vno = vno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "VisitlogDto [vno=" + vno + ", writer=" + writer + ", pw=" + pw + ", content=" + content + ", date="
				+ date + "]";
	}
	

	
	
	
	
	
	
}
