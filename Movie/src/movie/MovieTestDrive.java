package movie;

public class MovieTestDrive {
	
	public static void main(String[] args) {
		Movie one = new Movie();
		one.title = "Gone with the Wind";
		one.genre = "Romance";
		one.rating = 2;
		one.playIt();
		Movie two = new Movie();
		two.title = "Step Brothers";
		two.genre = "Comedy";
		two.rating = 4;
		two.playIt();
		Movie three = new Movie();
		three.title = "Finding Nemo";
		three.genre = "Kids";
		three.rating = 3;
		three.playIt();
	}
}