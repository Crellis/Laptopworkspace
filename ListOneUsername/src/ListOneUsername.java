import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ListOneUsername {

	public static void main(String[] args) throws FileNotFoundException {
	
		Scanner diskScanner = new Scanner(new File("email.txt"));
		PrintStream diskWriter = new PrintStream("usernames.txt");
		char symbol;
		
		symbol = diskScanner.findInLine(".").charAt(0);
		
		while (symbol != '@') {
			diskWriter.print(symbol);
			symbol = diskScanner.findInLine(".").charAt(0);
		}
		
		diskWriter.println();
	}

}
