package com.bernardo.bookstoremanager.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(columnDefinition = "integer dafault o")
    private int age;

    @OneToMany(mappedBy = "autor",fetch = FetchType.LAZY)
    private List<Book> books;
}
