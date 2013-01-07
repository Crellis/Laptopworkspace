import java.util.Scanner;

public class NicePrice {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int age;
		double price = 0.00;
		char reply;
		boolean isKid, isSenior, hasCoupon, hasNoCoupon;
		
		System.out.print("How old are you? ");
		age = myScanner.nextInt();
		
		System.out.print("Have you got a coupon? (Y/N) ");
		reply = myScanner.findInLine(".").charAt(0);
		
		isKid = age > 12;
		isSenior = age >= 65;
		hasCoupon = reply == 'Y' || reply == 'y';
		hasNoCoupon = reply == 'N' || reply == 'n';
		
		if (!isKid && !isSenior) {
			price = 9.25;
		}
		if (isKid || isSenior) {
			price = 5.25;
		}
		if (hasCoupon) {
			price = 2.00;
		}
		if (!hasCoupon && !hasNoCoupon) {
			System.out.println("Huh??");
		}
		System.out.print("Please insert €");
		System.out.print(price);
		System.out.print(". ");
		System.out.println("Enjoy the Show  :) ");
	}

}
