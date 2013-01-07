package beersong;

public class BeerSong {

	/**
	 * Author: Craig Ellis
	 * Date 10/10/2012
	 */
	public static void main(String[] args) {
		int beerNum = 99;
		String word = "bottles";
		
		while (beerNum > 0) {
			
			if (beerNum == 1) {
				word = "bottle"; // singular, One bottle
			}
			if (beerNum == 99) {
				System.out.println(beerNum + " " + word + " of beer on the wall!");
			}
			
			System.out.println(beerNum + " " + word + " of beer.");
			System.out.println("Take one Down.");
			System.out.println("Pass it Around.");
			beerNum = beerNum -1;
			
			if (beerNum > 0) {
				System.out.println(beerNum + " " + word + " of beer on the wall!");
			} else {
				System.out.println("No more bottles of beer on the wall!");
			} // end else
		} // end while loop
	} // end main method
} // end class