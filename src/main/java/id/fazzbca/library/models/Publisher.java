package id.fazzbca.library.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @UuidGenerator
    private String id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String address;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;
    
    private Boolean isDeleted = false;
    
    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    } 
}