package jsp.Spring.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.Spring.Entity.Book;
import jsp.Spring.Respository.BookRepository;


@Repository
public class BookDAO {
	
	@Autowired
	private BookRepository bookRepository;
	

	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	
	public List<Book> getAllBook() {
		List<Book> book = bookRepository.findAll();
		return book;
	}

	public Optional<Book> getBookById(int id){
		Optional<Book> book = bookRepository.findById(id);
		if(book.isPresent()) {
		    return book;
		}else {
			return null;
		}
	}
 
	public Optional<Book> deleteBookById(int id){
		Optional<Book> deleteBook = bookRepository.findById(id);
		if(deleteBook.isPresent()) {
			Book book = deleteBook.get();
		    bookRepository.delete(book);
		    return deleteBook;
		}else {
			return null;
		}
	}

	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	

	public List<Book> getBookByGenre(String genre){
		List<Book> book =bookRepository.getBookByGenre(genre);
		if(!book.isEmpty()) {
			return book;
		}else {
			return null;
		}
	}

}
