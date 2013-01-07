
public class SweetsBoolean {

	public static void main(String[] args) {
		
		int gumballs, kids, gumballsPerKid;
		boolean eachKidGetsTen;
		
		gumballs = 140;
		kids = 15;
		gumballsPerKid = gumballs / kids;
		
		System.out.print("True or False? ");
		System.out.println("Each kid gets at least 10 Gumballs. ");
		eachKidGetsTen = gumballsPerKid >=10;
		System.out.println("Answer equals " + eachKidGetsTen + "!");

	}

}
