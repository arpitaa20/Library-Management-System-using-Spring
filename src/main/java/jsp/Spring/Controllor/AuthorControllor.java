package jsp.Spring.Controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Author;
import jsp.Spring.Service.AuthorService;


@RestController
@RequestMapping("/author")
public class AuthorControllor {
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(@RequestBody Author author){
		return authorService.saveAuthor(author);
	}
	
	@GetMapping("/allauthor")
	public ResponseEntity<ResponseStructure<List<Author>>> getAllAuthor(){
		return authorService.getAllAuthor();
	}
	
	@GetMapping("/getauthor/{id}")
	public ResponseEntity<ResponseStructure<Author>> getAuthorById(@PathVariable int id){
		return authorService.getAuthorById(id);
	}
	
	@DeleteMapping("/deleteauthor/{id}")
	public ResponseEntity<ResponseStructure<Author>> deleteAuthorById(@PathVariable int id){
		return authorService.deleteAuthorById(id);
	}
	
	@PutMapping("/updateauthor")
	public ResponseEntity<ResponseStructure<Author>> updateAuthor(@RequestBody Author author){
		return authorService.updateAuthor(author);
	}

}
