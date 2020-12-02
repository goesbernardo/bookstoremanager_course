package com.bernardo.bookstoremanager.repository;

import com.bernardo.bookstoremanager.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
