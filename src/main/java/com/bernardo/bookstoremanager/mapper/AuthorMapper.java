package com.bernardo.bookstoremanager.mapper;

import com.bernardo.bookstoremanager.dto.AuthorDTO;
import com.bernardo.bookstoremanager.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author toModel (AuthorDTO authorDTO);

    AuthorDTO toDTO(Author author);
}
