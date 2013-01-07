import java.util.Scanner;

public class TicketPrice {

	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int age;
		double price = 0.00;
		
		System.out.println("How old are you? ");
		age = myScanner.nextInt();
		
		if (age >= 12 && age < 65) {
			price = 12.95;
		}
		if (age <12 || age >= 65) {
			price = 7.25;
		}
		
		System.out.print("Please insert €");
		System.out.print(price);
		System.out.print(". ");
		System.out.println("Enjoy the Show  :) ");
		
		
	}

}
