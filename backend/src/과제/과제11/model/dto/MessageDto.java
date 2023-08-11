package 과제.과제11.model.dto;

public class MessageDto {
	
	private int pno;
	private int ptaker;
	private int psender;
	private String pcontent;
	private String pdate;
	private String preply;
	
	
	
	
	
	public MessageDto(int pno, int ptaker, int psender, String pcontent, String pdate, String preply) {
		super();
		this.pno = pno;
		this.ptaker = ptaker;
		this.psender = psender;
		this.pcontent = pcontent;
		this.pdate = pdate;
		this.preply = preply;
	}
	
	
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getPtaker() {
		return ptaker;
	}
	public void setPtaker(int ptaker) {
		this.ptaker = ptaker;
	}
	public int getPsender() {
		return psender;
	}
	public void setPsender(int psender) {
		this.psender = psender;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getPreply() {
		return preply;
	}
	public void setPreply(String preply) {
		this.preply = preply;
	}



	@Override
	public String toString() {
		return "MessageDto [pno=" + pno + ", ptaker=" + ptaker + ", psender=" + psender + ", pcontent=" + pcontent
				+ ", pdate=" + pdate + ", preply=" + preply + "]";
	}
	
	
	
	

}
