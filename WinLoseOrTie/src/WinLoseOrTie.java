import java.util.Scanner;
import static java.lang.System.out;

public class WinLoseOrTie {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int Ireland, Australia;
		
		out.print("Ireland & Australia Scores?  ");
		Ireland = myScanner.nextInt();
		Australia = myScanner.nextInt();
		out.println();
		
		if (Ireland > Australia) {
			out.println("Ireland win!....");
			out.print("Ireland:    ");
			out.println(Ireland);
			out.print("Australia:    ");
			out.println(Australia);
		} else if(Australia > Ireland) {
			out.println("Australia win!....");
			out.print("Australia:    ");
			out.println(Australia);
			out.print("Ireland:    ");
			out.println(Ireland);
		} else {
			out.println("It's a tie!!!!");
			out.print("Ireland:    ");
			out.println(Ireland);
			out.print("Australia:    ");
			out.println(Australia);
		}
	}

}
