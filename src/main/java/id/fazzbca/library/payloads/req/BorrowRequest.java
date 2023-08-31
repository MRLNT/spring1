package id.fazzbca.library.payloads.req;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowRequest {
    //uniq
    private String bookId;
    private String userId;
    private LocalDate borrowDate;
    private LocalDate dueDate;
}
