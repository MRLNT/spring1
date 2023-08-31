package id.fazzbca.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import id.fazzbca.library.models.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, String> {
}