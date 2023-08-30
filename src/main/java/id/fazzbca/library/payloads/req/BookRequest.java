package id.fazzbca.library.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookRequest {
    @NotEmpty(message = "title is required")
    private String judul;

    @Size(max = 4, message = "tahun terbit harus 4 karakter")
    private String tahunTerbit;
    
    @NotEmpty(message = "author is required")
    private String namaPengarang;

    private String namaPenerbit;
}
