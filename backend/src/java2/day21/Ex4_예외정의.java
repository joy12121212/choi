package java2.day21;

public class Ex4_예외정의 {
	public static void main(String[] args) {
		Account account = new Account();
		
		account.deposit(10000);
		System.out.println(account.getBalance());
		
		
		try {
			account.whtidraw(5000);
		} catch (Ex4_잔고부족예외 e) {
			System.out.println("오류 뭐야 " + e);
		}

		try {
			account.whtidraw(20000);
		} catch (Ex4_잔고부족예외 e) {
			System.out.println("오류뭥 ㅑ2 " + e);
		}

	}

}
