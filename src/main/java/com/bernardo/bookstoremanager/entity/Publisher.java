package com.bernardo.bookstoremanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Publisher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true, length = 5)
    private String code;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate fundationDate;

    @OneToMany(mappedBy = "publisher",fetch = FetchType.LAZY)
    private List<Book> books;
}
