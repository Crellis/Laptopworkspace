import java.util.Scanner;
import static java.lang.System.out;

public class Scoreboard {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int dublin, kerry;
		WhoWins who;
		
		out.print("Dublin and Kerry Scores?   ");
		dublin = myScanner.nextInt();
		kerry = myScanner.nextInt();
		out.println();
		
		if (dublin > kerry) {
			who = WhoWins.home;
			out.println("Dublin win :-)  ");
		} else if (kerry > dublin) {
			who = WhoWins.visitor;
			out.println("Kerry win :-( ");
		} else {
			who = WhoWIns.neither;
			out.println("It's a tie :-| ");
		}
		
		out.println();
		out.println("Todays game is brought to you by BargainTown!");
		out.println("The number one store for bargain prices!");
		out.println();
		out.println("And remember we wontbe beaten on price!");
		out.println();
		out.println();
		
		if (who == WhoWins.home) {
			out.println("We beat them good,didn;t we?");
		}
		if (who == WhoWins.visitor) {
			out.println("The umpire had a shocking game!");
		}
		if (who == WhoWins.neither) {
			out.println("Looks like we have a replay on our hands!");
		}
		
	}

}
