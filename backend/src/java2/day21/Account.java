package java2.day21;

public class Account {
	private long balance;
	
	public Account() {}
	public long getBalance() {return balance;}
	public void deposit (int money) {
		balance += money;
	}

	//출금 메소드
	public void whtidraw(int money) throws Ex4_잔고부족예외 {
		if (this.balance < money) {
			// 예금액이 부족하면 출금 금지.. // 예외 발생하지 않지만 고의적으로 예외를 일부러 만들었다
			throw new Ex4_잔고부족예외("잔고가 부족해 : " + (money-this.balance) + " 만큼 부족함");
		}this.balance -= money;
	}
	
	
	
}
