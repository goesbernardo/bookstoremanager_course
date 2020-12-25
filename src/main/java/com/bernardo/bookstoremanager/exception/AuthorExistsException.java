package com.bernardo.bookstoremanager.exception;

import javax.persistence.EntityExistsException;

public class AuthorExistsException extends EntityExistsException {

    public AuthorExistsException(String name) {
        super(String.format("user with name already exists", name));

    }
}
