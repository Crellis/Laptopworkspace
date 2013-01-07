package cashRegister;

public class CashRegisterTester {

	public static void main(String[] args) {
		CashRegister register = new CashRegister();
		
		register.recordPurchase(29.50);
		register.recordPurchase(9.25);
		register.enterPayment(50.00);
		
		double change = register.giveChange();
		
		System.out.println(change);
		
	}

}
