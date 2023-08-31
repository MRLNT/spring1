package id.fazzbca.library.services.borrow;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.fazzbca.library.payloads.req.BorrowRequest;
import id.fazzbca.library.payloads.res.ResponseHandler;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import id.fazzbca.library.models.Book;
import id.fazzbca.library.models.Borrow;
import id.fazzbca.library.models.User;
import id.fazzbca.library.repositories.BookRepository;
import id.fazzbca.library.repositories.BorrowRepository;
import id.fazzbca.library.repositories.UserRepository;

@Service
public class BorrowServiceImpl implements BorrowService{

    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public ResponseEntity<?> createBorrow(BorrowRequest request) {
        try {
            User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
            Book book = bookRepository.findById(request.getBookId()).orElseThrow(() -> new IllegalArgumentException("Book not found"));

            Boolean isAvailable = book.getIsAvailable();
            if (isAvailable == null || !isAvailable) {
                throw new IllegalArgumentException("Buku tidak tersedia");
            }

            Borrow borrow = new Borrow(book, user, LocalDate.now(), LocalDate.now().plusDays(14));
            borrowRepository.save(borrow);

            book.setIsAvailable(false);
            bookRepository.save(book);

            return ResponseHandler.responseData(201, "Peminjaman berhasil", borrow);
        }       catch (NumberFormatException e) {
            return ResponseHandler.responseMessage(400, "ID buku tidak valid", false);
        }       catch (IllegalArgumentException e) {
            return ResponseHandler.responseMessage(404, "Data tidak ditemukan", false);
        }
    }

    @Override
    public ResponseEntity<?> updateBorrowService(String id, BorrowRequest request) {
        // Find the borrow by id
        Borrow borrow = borrowRepository.findById(id).orElseThrow(() -> new NoSuchElementException("ID not found"));
        Book book = bookRepository.findById(request.getBookId()).orElseThrow(() -> new NoSuchElementException("Book not found"));
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new NoSuchElementException("User not found"));

        // Update data
        if (request.getBookId() != null && !request.getBookId().isEmpty()) {
            borrow.setBook(book);
        }
        if (request.getUserId() != null && !request.getUserId().isEmpty()) {
            borrow.setUser(user);
        }

        borrow.setReturnDate(LocalDate.now());
        borrow.setReturned(true);
        borrowRepository.save(borrow);

        book.setIsAvailable(true);
        bookRepository.save(book);

        return ResponseHandler.responseData(200, "Pengembalian Berhasil", borrow);
    }

    @Override
    public ResponseEntity<?> getBorrowsService() {
        // get all
        List<Borrow> borrows = borrowRepository.findAll();
        return ResponseHandler.responseData(200, "success", borrows);
    }
}