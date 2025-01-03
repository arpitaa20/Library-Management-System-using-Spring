package jsp.Spring.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.Spring.Entity.Author;
import jsp.Spring.Respository.AuthorRepository;

@Repository
public class AuthorDAO {
	
	@Autowired
	private AuthorRepository authorRepository;
	

	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}
	

	public List<Author> getAllAuthor() {
		List<Author> author = authorRepository.findAll();
		return author;
	}

	public Optional<Author> getAuthorById(int id){
		Optional<Author> author = authorRepository.findById(id);
		if(author.isPresent()) {
		    return author;
		}else {
			return null;
		}
	}
 
	public Optional<Author> deleteAuthorById(int id){
		Optional<Author> deleteAuthor = authorRepository.findById(id);
		if(deleteAuthor.isPresent()) {
			Author author=deleteAuthor.get();
		    authorRepository.delete(author);
		    return deleteAuthor;
		}else {
			return null;
		}
	}

	public Author updateAuthor(Author author) {
		return authorRepository.save(author);
	}
}
