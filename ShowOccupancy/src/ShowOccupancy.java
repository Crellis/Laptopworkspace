import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;

public class ShowOccupancy {

	public static void main(String[] args) throws FileNotFoundException {
	
		Scanner diskScanner = new Scanner(new File("occupancy"));
		
		out.println("Room\tGuests");
		
		for (int roomNum = 1; roomNum <= 20; roomNum++) {
			out.print(roomNum);
			out.print("\t");
			out.println(diskScanner.nextInt());
		}
	}

}
