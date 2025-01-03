package jsp.Spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.Spring.DAO.BookDAO;
import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	public ResponseEntity<ResponseStructure<Book>> saveBook(Book book){
		Book recievedBook = bookDAO.saveBook(book);
		
		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(recievedBook);
		
		return new ResponseEntity<ResponseStructure<Book>> (structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBook(){
		List<Book> book = bookDAO.getAllBook();
		
		ResponseStructure<List<Book>> structure= new ResponseStructure<List<Book>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(book);
		return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Book>> getBookById(int id){
		Optional<Book> getBook = bookDAO.getBookById(id);
		
		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		if(getBook.isPresent()) {
		    structure.setStatusCode(HttpStatus.FOUND.value());
		    structure.setMessage("Found");
		    structure.setData(getBook.get());
		    return new ResponseEntity<ResponseStructure<Book>> (structure, HttpStatus.FOUND);
		}else {
			return null;
		}	
	}
	
	public ResponseEntity<ResponseStructure<Book>> deleteBookById(int id){
		Optional<Book> deleteBook = bookDAO.deleteBookById(id);
		
		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		if(deleteBook.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Deleted");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<Book>> updateBook(Book book){
		Book updateBook = bookDAO.saveBook(book);
		
		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(updateBook);
		return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByGenre(String genre){
		List<Book> book =bookDAO.getBookByGenre(genre);
		
		ResponseStructure<List<Book>> structure = new ResponseStructure<List<Book>>();
		if(!book.isEmpty()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Found Genre");
			structure.setData(book);
			return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.OK);
		}else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Not found Genre");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.NOT_FOUND);
		}
		
	}



}
