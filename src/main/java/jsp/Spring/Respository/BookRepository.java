package jsp.Spring.Respository;


import org.springframework.data.jpa.repository.JpaRepository;

import jsp.Spring.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
