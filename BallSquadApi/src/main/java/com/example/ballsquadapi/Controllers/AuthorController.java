package com.example.ballsquadapi.Controllers;

import com.example.ballsquadapi.Client.OpenLibraryClient;
import com.example.ballsquadapi.Models.Author;
import com.example.ballsquadapi.Repositories.AuthorRepository;
import com.example.ballsquadapi.Services.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final OpenLibraryClient client;
    private  final AuthorRepository repository;
    private final AuthorService authorService;


    public AuthorController(OpenLibraryClient client, AuthorRepository repository, AuthorService authorService) {
        this.client = client;
        this.repository = repository;
        this.authorService = authorService;
    }
    @GetMapping
    public List<Author> getAuthors(@RequestParam("q") String query) {
        List<Author> authors = repository.findByAuthorName(query);
        if (authors.isEmpty()) {
              authors = authorService.fetchAndSaveAuthorsFromOpenLibrary(query) ;
        }
        return authors;
    }


}

