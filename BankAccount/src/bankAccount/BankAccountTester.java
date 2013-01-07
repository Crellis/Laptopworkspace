package bankAccount;

public class BankAccountTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BankAccount accountNum = new BankAccount();
		accountNum.deposit(2000);
		accountNum.withdraw(500);
		System.out.println(accountNum.getBalance());

	}

}
