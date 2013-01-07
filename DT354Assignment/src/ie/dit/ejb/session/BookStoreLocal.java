package ie.dit.ejb.session;

import ie.dit.ejb.entity.Book;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BookStoreLocal {
	
	public void deleteAllBooks();
	
	public void createBook(String author, String title);
	
	public List<Book> getAllBooks();
	
	public List<Book> getBooksByAuthor(String author);
}
