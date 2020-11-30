package com.bernardo.bookstoremanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

    MALE("Male"),
    FAMALE("Female");

    private String description;
}
