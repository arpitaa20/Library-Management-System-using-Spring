package jsp.Spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.Spring.DAO.AuthorDAO;
import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Author;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorDAO authorDAO;
	
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(Author author){
		Author recievedAuthor = authorDAO.saveAuthor(author);
		
		ResponseStructure<Author> str=new ResponseStructure<Author>();
		str.setStatusCode(HttpStatus.CREATED.value());
		str.setMessage("Success");
		str.setData(recievedAuthor);
		
		return new ResponseEntity<ResponseStructure<Author>> (str, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Author>>> getAllAuthor(){
		List<Author> author = authorDAO.getAllAuthor();
		
		ResponseStructure<List<Author>> structure= new ResponseStructure<List<Author>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(author);
		return new ResponseEntity<ResponseStructure<List<Author>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Author>> getAuthorById(int id){
		Optional<Author> getAuthor = authorDAO.getAuthorById(id);
		
		ResponseStructure<Author> structure = new ResponseStructure<Author>();
		if(getAuthor.isPresent()) {
		    structure.setStatusCode(HttpStatus.FOUND.value());
		    structure.setMessage("Found");
		    structure.setData(getAuthor.get());
		    return new ResponseEntity<ResponseStructure<Author>> (structure, HttpStatus.FOUND);
		}else {
			return null;
		}	
	}
	
	public ResponseEntity<ResponseStructure<Author>> deleteAuthorById(int id){
		Optional<Author> deleteAuthor = authorDAO.deleteAuthorById(id);
		
		ResponseStructure<Author> structure = new ResponseStructure<Author>();
		if(deleteAuthor.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Deleted");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Author>>(structure, HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<Author>> updateAuthor(Author author){
		Author updateAuthor = authorDAO.saveAuthor(author);
		
		ResponseStructure<Author> structure = new ResponseStructure<Author>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(updateAuthor);
		return new ResponseEntity<ResponseStructure<Author>>(structure, HttpStatus.OK);
	}

}
