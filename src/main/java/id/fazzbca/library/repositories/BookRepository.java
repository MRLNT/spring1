package id.fazzbca.library.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import id.fazzbca.library.models.Book;

public interface BookRepository extends JpaRepository<Book, String>{
    List<Book> findByIsDeleted(Boolean isDeleted);
}
