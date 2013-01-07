package bankAccount;

/*
   A bank account has a balance that can be changed,
   by deposits and withdrawals.
 */

public class BankAccount {

	private double balance;
	
	public BankAccount() {
		balance = 0;
	}
	
	public BankAccount (double initialBalance){
	
		balance = initialBalance;
	}
	
	public void deposit(double amount) {
		
		double newBalance = balance + amount;
		balance = newBalance;
	}
	/*
	 * Withdraws money from the bank account.
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {
		
		double newBalance = balance - amount;
		balance = newBalance;
	}
	/*
	 * Gets the current balance of the bank account.
	 * @return the current balance
	 */	
	public double getBalance() {
	
		return balance;
	}
	
}
