package id.fazzbca.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.fazzbca.library.payloads.req.BorrowRequest;
import id.fazzbca.library.services.borrow.BorrowService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/borrows")
public class BorrowController {
    @Autowired
    BorrowService borrowService;

    @PostMapping
    public ResponseEntity<?> createBorrow(@RequestBody @Valid BorrowRequest request){
        return borrowService.createBorrow(request);
    }

    // pengembalian disini
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBorrow(@PathVariable(value = "id") String id, @RequestBody BorrowRequest request){
        return borrowService.updateBorrowService(id, request);
    }

    // get all borrowed book
    @GetMapping
    public ResponseEntity<?> getBorrows(){
        return borrowService.getBorrowsService();
    }
}