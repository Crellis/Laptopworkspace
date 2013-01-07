import java.util.Scanner;

public class GetUserName {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		char symbol;
		
		symbol = myScanner.findInLine(".").charAt(0);
		
		while (symbol != '@') {
			System.out.print(symbol);
			symbol = myScanner.findInLine(".").charAt(0);
		}
		System.out.println();
	}

}
