package id.fazzbca.library.services.user;

import org.springframework.http.ResponseEntity;

import id.fazzbca.library.payloads.req.UserRequest;

public interface UserService {
    // create
    ResponseEntity<?> addUserService(UserRequest request);
    // find by name
    ResponseEntity<?> getLoginByNameService(UserRequest request);
}