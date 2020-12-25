package com.bernardo.bookstoremanager.service;

import com.bernardo.bookstoremanager.AuthorDTOBuilder;
import com.bernardo.bookstoremanager.dto.AuthorDTO;
import com.bernardo.bookstoremanager.entity.Author;
import com.bernardo.bookstoremanager.exception.AuthorExistsException;
import com.bernardo.bookstoremanager.mapper.AuthorMapper;
import com.bernardo.bookstoremanager.repository.AuthorRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    private final AuthorMapper  authorMapper = AuthorMapper.INSTANCE;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private AuthorDTOBuilder authorDTOBuilder;

    @BeforeEach
    void setUp(){
        authorDTOBuilder = AuthorDTOBuilder.builder().build();
        AuthorDTO authorDTO = authorDTOBuilder.buildAuthorDTO();
    }

    @Test
    void whenNewAuthorIsInformedThenBeCreated(){

        //given
        AuthorDTO expectedAuthorToCreate = authorDTOBuilder.buildAuthorDTO();
        Author expectedToCreatedAuthor = authorMapper.toModel(expectedAuthorToCreate);

        //when
        when(authorRepository.save(expectedToCreatedAuthor)).thenReturn(expectedToCreatedAuthor);
        when(authorRepository.findByName(expectedAuthorToCreate.getName())).thenReturn(Optional.empty());

        //then
        AuthorDTO createdAuthorDTO = authorService.create(expectedAuthorToCreate);
        assertThat(createdAuthorDTO, Is.is(equalTo(expectedAuthorToCreate)));
    }

   /* @Test
    void whenExistingAuthorIsInformedThenExceptionShouldBeTrhow(){

        //given
        AuthorDTO expectedAuthorToCreate = authorDTOBuilder.buildAuthorDTO();
        Author expectedToCreatedAuthor = authorMapper.toModel(expectedAuthorToCreate);

        //when
        when(authorRepository.findByName(expectedAuthorToCreate.getName())).thenReturn(Optional.of(expectedToCreatedAuthor));

        assertThrows(AuthorExistsException.class,() -> authorService.create(expectedAuthorToCreate));

        //then
        AuthorDTO createdAuthorDTO = authorService.create(expectedAuthorToCreate);
        assertThat(createdAuthorDTO, Is.is(IsEqual.equalTo(expectedAuthorToCreate)));
    }

*/

    @Test
    void whenValidIdIsGivenBeReturned(){
        AuthorDTO expectedFoundauthorDto = authorDTOBuilder.buildAuthorDTO();
        Author expectedFoundAuthor = authorMapper.toModel(expectedFoundauthorDto);

        when(authorRepository.findById(expectedFoundauthorDto.getId())).thenReturn(Optional.of(expectedFoundAuthor));

        AuthorDTO foundAuthorDto = authorService.findById(expectedFoundauthorDto.getId());

        assertThat(foundAuthorDto,Is.is(equalTo(expectedFoundauthorDto)));

    }

     @Test
     void deleteAuthorById() {

         AuthorDTO expectedDeleteduthorDto = authorDTOBuilder.buildAuthorDTO();
         Author expectedDeletedAuthor = authorMapper.toModel(expectedDeleteduthorDto);

          Long expectedDeleterAuthorId = expectedDeleteduthorDto.getId();

          doNothing().when(authorRepository).deleteById(expectedDeleterAuthorId);

          authorService.delete(expectedDeleterAuthorId);

          verify(authorRepository,times(1)).deleteById(expectedDeleterAuthorId);



     }
}
