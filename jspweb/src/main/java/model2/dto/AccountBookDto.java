package model2.dto;

public class AccountBookDto {
	
	private int ano;
	private String content;
	private int money;
	private String date;
	
	//기본 생성자
	public AccountBookDto() {
		// TODO Auto-generated constructor stub
	}
	//풀 생성자
	public AccountBookDto(int ano ,String content, int money, String date) {
		super();
		this.ano = ano;
		this.content = content;
		this.money = money;
		this.date = date;
	}
	
	// 내용과 돈만 입력 하도록
	public AccountBookDto(String content, int money , String date) {
		super();
		this.content = content;
		this.money = money;
		this.date = date;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	@Override
	public String toString() {
		return "AccountBookDto [content=" + content + ", money=" + money + ", date=" + date + "]";
	}
	
	
	
	

}
