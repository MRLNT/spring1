package id.fazzbca.library.services.borrow;

import org.springframework.http.ResponseEntity;

import id.fazzbca.library.payloads.req.BorrowRequest;

public interface BorrowService {
    // create book
    ResponseEntity<?> createBorrow(BorrowRequest request);

    // get all books or by status deleted
    ResponseEntity<?> getBorrowsService();

    // update borrow by id
    ResponseEntity<?> updateBorrowService(String id, BorrowRequest request);
}