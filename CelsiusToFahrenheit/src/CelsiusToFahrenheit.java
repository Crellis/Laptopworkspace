import java.util.Scanner;

public class CelsiusToFahrenheit {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		double celsius, fahrenheit;
		
		System.out.print("Please enter the Celcius Temperature: ");
		celsius = myScanner.nextDouble();
		
		fahrenheit = 9.0 / 5.0 * celsius +32.0;
		
		System.out.print("Room Temperature? ");
		System.out.println(fahrenheit == 69.80000000000001);
		System.out.println("fahrenheit: ");
		System.out.println(fahrenheit);
		
	}

}
