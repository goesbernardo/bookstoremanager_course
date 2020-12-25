package com.bernardo.bookstoremanager.controller;

import com.bernardo.bookstoremanager.AuthorDTOBuilder;
import com.bernardo.bookstoremanager.dto.AuthorDTO;
import com.bernardo.bookstoremanager.service.AuthorService;
import com.bernardo.bookstoremanager.utils.JsonConverterUtils;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {


    private static final String API_URL = "/api/v1/authors";


    @Mock
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    private MockMvc mockMvc;

    private AuthorDTOBuilder authorDTOBuilder;

    private AuthorDTO authorDTO;

    @BeforeEach
    void setUp(){
        authorDTOBuilder = AuthorDTOBuilder.builder().build();
        mockMvc = MockMvcBuilders.standaloneSetup(authorController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenPostIsCalledThenStatusCreated() throws Exception {

        AuthorDTO expectedCreatedAuthorDTO = authorDTOBuilder.buildAuthorDTO();

        Mockito.when(authorService.create(expectedCreatedAuthorDTO)).thenReturn(expectedCreatedAuthorDTO);

        mockMvc.perform(post(API_URL).contentType(MediaType.APPLICATION_JSON)
                .content(JsonConverterUtils.asJsonString(expectedCreatedAuthorDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Is.is(expectedCreatedAuthorDTO.getId().intValue())))
                .andExpect(jsonPath("$.name", Is.is(expectedCreatedAuthorDTO.getName())))
                .andExpect(jsonPath("$.age", Is.is(expectedCreatedAuthorDTO.getAge())));
    }

    @Test
    void whenPostIsCalledWithourRequiredFiledThenBadRequestInformed() throws Exception {

        AuthorDTO expectedCreatedAuthorDTO = authorDTOBuilder.buildAuthorDTO();
        expectedCreatedAuthorDTO.setName(null);


        mockMvc.perform(post(API_URL).contentType(MediaType.APPLICATION_JSON)
                .content(JsonConverterUtils.asJsonString(expectedCreatedAuthorDTO)))
                .andExpect(status().isBadRequest());

    }





}
