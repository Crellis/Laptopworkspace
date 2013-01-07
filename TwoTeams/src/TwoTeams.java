import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class TwoTeams {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(in);
		int chelsea, manutd;
		
		out.print("Chelsea & ManUtd Scores? ");
		chelsea = myScanner.nextInt();
		manutd = myScanner.nextInt();
		out.println();
		
		if (chelsea > manutd) {
			out.print("Chelsea: ");
			out.println(chelsea);
			out.print("ManUtd: ");
			out.println(manutd);
		} else {
			out.print("ManUtd: ");
			out.println(manutd);
			out.print("Chelsea: ");
			out.println(chelsea);
		}
	}

}
