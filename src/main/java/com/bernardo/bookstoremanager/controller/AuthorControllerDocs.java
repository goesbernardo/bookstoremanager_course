package com.bernardo.bookstoremanager.controller;

import com.bernardo.bookstoremanager.dto.AuthorDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@Api("authors_management")
public interface AuthorControllerDocs {


    @ApiOperation(value = "author created")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "success author created"),
            @ApiResponse(code = 400, message = "error creating author")
    })

    AuthorDTO create(AuthorDTO authorDTO);

    @ApiOperation(value = "find author by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success author founded"),
            @ApiResponse(code = 404, message = "author not found")
    })
    AuthorDTO findById(Long id);

    @ApiOperation(value = "list all author")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " return all registred authors")
    })
    List<AuthorDTO> findAll();
}
