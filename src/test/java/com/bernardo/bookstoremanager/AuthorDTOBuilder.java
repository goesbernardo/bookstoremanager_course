package com.bernardo.bookstoremanager;

import com.bernardo.bookstoremanager.dto.AuthorDTO;
import lombok.Builder;

@Builder
public class AuthorDTOBuilder {

    @Builder.Default
    private final Long id =1L ;
    @Builder.Default
    private final String name = "goesBernardo";
    @Builder.Default
    private final Integer age = 34;

    public AuthorDTO buildAuthorDTO() {

        return new AuthorDTO(id,name,age);
    }
}
