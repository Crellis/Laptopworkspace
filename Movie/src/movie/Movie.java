package movie;

public class Movie {
	
	String title;
	String genre;
	int rating;
	
	void playIt() {
		System.out.println("Playing the movie");
		System.out.println("Title: " + title);
		System.out.println("Genre: " + genre);
		System.out.println("Rating: " + rating);
	}
}