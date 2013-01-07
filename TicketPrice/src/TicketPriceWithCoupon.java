import java.util.Scanner;

public class TicketPriceWithCoupon {
		
		public static void main(String[] args) {
			Scanner myScanner = new Scanner(System.in);
			int age;
			double price = 0.00;
			char reply;
			
			System.out.println("How old are you? ");
			age = myScanner.nextInt();
			
			System.out.println("Have you got a coupon? (Y/N)? ");
			reply = myScanner.findInLine(".").charAt(0);
			
			if (age >= 12 && age < 65) {
				price = 12.95;
			}
			if (age <12 || age >= 65) {
				price = 7.25;
			}
			if (reply == 'Y' || reply == 'y') {
				price -= 2.00;
			}
			if (reply != 'Y' || reply != 'y' && reply != 'N' && reply != 'n') {
				System.out.println("Huh?? That is not a valid option!");
			}
			
			System.out.print("Please insert €");
			System.out.print(price);
			System.out.print(". ");
			System.out.println("Enjoy the Show  :) ");
			
		}

	}
