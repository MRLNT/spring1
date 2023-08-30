package id.fazzbca.library.payloads.req;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String password;
}

//     @NotEmpty(message = "title is required")
//     private String judul;

//     @Size(max = 4, message = "tahun terbit harus 4 karakter")
//     private String tahunTerbit;
    
//     @NotEmpty(message = "author is required")
//     private String namaPengarang;

//     private String namaPenerbit;