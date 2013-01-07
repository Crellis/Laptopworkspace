package ie.dit.ejb.session;

import ie.dit.ejb.entity.Book;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BookStore implements BookStoreLocal, BookStoreRemote {

	@PersistenceContext
	EntityManager em;

	public void createBook(String author, String title) {

		Book newBook = new Book(author, title);
		em.persist(newBook);
	}


	public List<Book> getAllBooks() {

		 return (List<Book>) this.em.createNamedQuery("Book.findAll").getResultList();		 
	}


	public List<Book> getBooksByAuthor(String author){
		
		Query query = this.em.createNamedQuery("Book.findByAuthor");
		query.setParameter("a", author);
		
		return (List<Book>)query.getResultList();
	}
	
	public void deleteAllBooks(){
		
		List<Book> books = getAllBooks();
		
		for (Book b : books){
			em.remove(b);
		}
	}
}
