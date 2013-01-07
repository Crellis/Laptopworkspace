package cashRegister;

public class CashRegister {

	private double purchase;
	private double payment;
	
	public CashRegister() 
	{

	}

	public void recordPurchase(double amount) 
	{
		double newTotal = purchase + amount;
		purchase = newTotal;
	}
	
	public void enterPayment(double amount) 
	{
		
	}
	
	public double giveChange() 
	{ 
		double change = payment - purchase;
		purchase = 0;
		payment = 0;
		return change;
	}
}