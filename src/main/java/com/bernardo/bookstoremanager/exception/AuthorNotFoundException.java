package com.bernardo.bookstoremanager.exception;

import javax.persistence.EntityNotFoundException;

public class AuthorNotFoundException extends EntityNotFoundException {

    public AuthorNotFoundException(Long id) {

        super(String.format("Author Not Exists", id));
    }
}
