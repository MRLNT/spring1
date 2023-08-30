package id.fazzbca.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import id.fazzbca.library.models.User;

public interface UserRepository extends JpaRepository<User, String>{
    User findByName(String name);
    User findByPassword(String password);
}