package com.bernardo.bookstoremanager.service;

import com.bernardo.bookstoremanager.dto.AuthorDTO;
import com.bernardo.bookstoremanager.entity.Author;
import com.bernardo.bookstoremanager.exception.AuthorExistsException;
import com.bernardo.bookstoremanager.exception.AuthorNotFoundException;
import com.bernardo.bookstoremanager.mapper.AuthorMapper;
import com.bernardo.bookstoremanager.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    private AuthorRepository authorRepository;


    @Autowired
    public AuthorService(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    public AuthorDTO create(AuthorDTO authorDTO){
        verifyIfExists(authorDTO.getName());
        Author authorToCreate =  authorMapper.toModel(authorDTO);
        Author created = authorRepository.save(authorToCreate);
        return authorMapper.toDTO(created);
    }

    private void verifyIfExists(String authorName){
        authorRepository.findByName(authorName)
                .ifPresent(author -> {throw new AuthorExistsException(authorName);
                });


    }
    public AuthorDTO findById(Long id) {
       Author foundAuthor = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
       return authorMapper.toDTO(foundAuthor);
    }

    public List<AuthorDTO> findAll() {

        return authorRepository.findAll().stream().map(authorMapper::toDTO).collect(Collectors.toList());

    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }



}
