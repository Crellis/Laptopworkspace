import java.util.Scanner;

public class Sweets {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int gumballs, kids, gumballsPerKid;
		
		System.out.print("How many gumballs? How Many kids?");
		
		gumballs = myScanner.nextInt();
		kids = myScanner.nextInt();
		
		gumballsPerKid = gumballs / kids;
		
		System.out.print("Each kid gets ");
		System.out.print(gumballsPerKid);
		System.out.println(" gumballs.");

	}

}
