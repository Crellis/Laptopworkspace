import static java.lang.System.out;

public class ElevatorFitter {

	
	public static void main(String[] args) {
		
		int weightOfAPerson;
		int elevatorWeightLimit;
		int numberOfPeople;
		
		weightOfAPerson = 120;
		elevatorWeightLimit = 1400;
		numberOfPeople = elevatorWeightLimit / weightOfAPerson;
		
		out.print("You Can Fit ");
		out.print(numberOfPeople);
		out.println(" people on the elevator");
		
	}

}
