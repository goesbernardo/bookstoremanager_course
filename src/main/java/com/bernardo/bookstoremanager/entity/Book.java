package com.bernardo.bookstoremanager.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String ISBN;

    private int pages;

    private int chapters;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Autor autor;

    private Publisher publisher;

}
