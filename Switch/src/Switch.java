import java.util.Scanner;
import java.util.Random;
import static java.lang.System.out;

public class Switch {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		Random myRandom = new Random();
		int randomNumber;
		
		out.print("Type your question here.....");
		myScanner.nextLine();
		
		randomNumber = myRandom.nextInt(10) + 1;
		
		switch (randomNumber) {
		case 1:
			out.println("Yes. Inst that obvious??");
			break;
			
		case 2:
			out.println("No and don't ask me that again!");
			break;

		case 3:
			out.println("That would be an ecumenical matter!");
			break;
			
		case 4:
			out.println("Yes, only if you say please");
			break;
			
		case 5:
			out.println("That makes no sense");
			break;
			
		case 6:
			out.println("I know you are but what am I??");
			break;
			
		case 7:
			out.println("Why the long face?");
			break;
			
		case 8:
			out.println("Your wasting my time asking that!");
			break;
			
		case 9:
			out.println("Are you slow???");
			break;
			
		case 10:
			out.println("No chance!");
			break;
			
		default:
			out.println("I think I'm Broken!!!  :(");
			break;
		}
		out.println("Goodbye!");
	}

}
