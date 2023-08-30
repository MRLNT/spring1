package id.fazzbca.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.fazzbca.library.models.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, String>{
    // sql : mencari author dari nama author: select * from authors where name = ?
    List<Publisher> findByNameContaining(String name);

    @Query(value = "select * from authors where name like %?%", nativeQuery = true)
    List<Publisher> getPublisherByName(String name);

    Publisher findByName(String name);
    List<Publisher> findByIsDeleted(Boolean isDeleted);
    List<Publisher> findByIsDeletedFalse();
    List<Publisher> findByIsDeletedTrue();
    
}