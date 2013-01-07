import java.util.Random;
import static java.lang.System.out;

public class BlackJack {

	public static void main(String[] args) {
		Random myRandom = new Random();
		int card;
		int total = 0;
		
		out.println("Card        Total");
		
		while (total < 21) {
			card = myRandom.nextInt(11) + 1;
			total += card;
			
			out.print(card);
			out.print("              ");
			out.println(total);
		}
		if (total == 21) {
			out.println("You Win!!!!!!!!!");
		} else {
			out.println("You Lose!  :(");
		}
	}

}
