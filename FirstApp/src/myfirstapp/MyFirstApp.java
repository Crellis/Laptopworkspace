package myfirstapp;

public class MyFirstApp {
	
	public static void main (String[] args) {
		System.out.println("I Rule!");
		System.out.println("The World");
		
		int x = 4; // assign 4 to x
		while (x > 3) {
			// loop code will run because
			// x is greater than 3
			x = x - 1; // or we would loop infinity
		}
		
		int z = 27;
		while (z == 17) {
			// loop code will not run because
			// z is not equal to 17
		}
		
		int c = 1;
		System.out.println("Before the Lopp");
		while (c < 4) {
			System.out.println("In the loop");
			System.out.println("Value of c is " + c);
			c = c + 1;
		}
		System.out.println("This is after the Loop!");
		
		int d = 3;
		if (d == 3) {
			System.out.println("d must be 3");
		} else {
			System.out.println("d must NOT be 3");
		}
		System.out.println("Run anyway!");
	}
}