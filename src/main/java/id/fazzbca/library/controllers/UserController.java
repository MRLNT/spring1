package id.fazzbca.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.fazzbca.library.payloads.req.UserRequest;
import id.fazzbca.library.services.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequest request){
        ResponseEntity<?> responseEntity = userService.addUserService(request);
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRequest request){
        return userService.getLoginByNameService(request);
    }
    
}