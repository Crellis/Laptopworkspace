import java.util.Random;

public class SpecialOffer {

	public static void main(String[] args) {
		Random myRandom = new Random();
		int randomNumber = myRandom.nextInt(10) + 1;
		
		if (randomNumber == 7) {
			System.out.println("An Special Offer just for you!!!!!!!!");
		}

		System.out.println(randomNumber);
	}

}
