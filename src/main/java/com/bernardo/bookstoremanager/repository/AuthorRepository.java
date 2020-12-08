package com.bernardo.bookstoremanager.repository;

import com.bernardo.bookstoremanager.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
