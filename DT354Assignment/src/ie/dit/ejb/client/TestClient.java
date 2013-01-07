package ie.dit.ejb.client;

import ie.dit.ejb.entity.Book;
import ie.dit.ejb.session.BookStoreRemote;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestClient {
	
	public static void main(String[] args) {

		Context context;
		try {

			Hashtable<String, String> env = new Hashtable<String, String>();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			env.put(Context.PROVIDER_URL, "localhost:1099");

			context = new InitialContext(env);
			
			BookStoreRemote beanRemote = (BookStoreRemote) context.lookup("BookStore/remote");
			
			
			
			

			beanRemote.createBook("The first book", "J. Munnelly");
			beanRemote.createBook("The second book", "N. O Connor");
			beanRemote.createBook("The third book", "J. Munnelly");

			List<Book> books = beanRemote.getAllBooks();

			for (Book b : books) {
				System.out.println(b.toString());
			}

			books = beanRemote.getBooksByAuthor("J. Munnelly");

			for (Book b : books) {

				System.out.println(b.toString());
			}
			
			beanRemote.deleteAllBooks();

		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
