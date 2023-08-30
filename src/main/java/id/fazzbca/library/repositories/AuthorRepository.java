package id.fazzbca.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.fazzbca.library.models.Author;
import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, String>{
    // sql : mencari author dari nama author: select * from authors where name = ?
    List<Author> findByNameContaining(String name);

    Author findByName(String name);

    @Query(value = "select * from authors where name like %?%", nativeQuery = true)
    List<Author> getAuthorByName(String name);
}