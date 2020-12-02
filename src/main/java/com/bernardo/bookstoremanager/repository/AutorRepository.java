package com.bernardo.bookstoremanager.repository;

import com.bernardo.bookstoremanager.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
}
