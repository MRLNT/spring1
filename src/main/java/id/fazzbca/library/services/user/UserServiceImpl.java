package id.fazzbca.library.services.user;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.fazzbca.library.models.User;
import id.fazzbca.library.payloads.req.UserRequest;
import id.fazzbca.library.payloads.res.ResponseHandler;
import id.fazzbca.library.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> addUserService(UserRequest request) {
        // cek input name required
        if (request.getName() == null || request.getName() == "") {
            throw new IllegalArgumentException("Name user is required");
        }
        User user = new User(request.getName(), request.getPassword());
        // save ke db
        userRepository.save(user);
        return ResponseHandler.responseMessage(201, "User successfully added", true);

    }

    @Override
    public ResponseEntity<?> getLoginByNameService(UserRequest request) {
        String name = request.getName();
        User userName = userRepository.findByName(name);

        String password = request.getPassword();
        // User userPassword = userRepository.findByPassword(password);

        if (userName == null) {
            throw new NoSuchElementException("user tidak ditemukan");
        }
        if (!password.equals(userName.getPassword())) {
            throw new NoSuchElementException("password salah");
        }

        return ResponseHandler.responseMessage(200, "login berhasil", true);
    }
}


