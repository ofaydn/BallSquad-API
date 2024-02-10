package com.example.ballsquadapi.Controllers;
import com.example.ballsquadapi.Client.OpenLibraryClient;
import com.example.ballsquadapi.Models.Author;
import com.example.ballsquadapi.Repositories.AuthorRepository;
import com.example.ballsquadapi.Services.AuthorService;
import com.example.ballsquadapi.Services.LogService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final OpenLibraryClient client;
    private  final AuthorRepository repository;
    private final AuthorService authorService;
    private final LogService logService;
    public AuthorController(OpenLibraryClient client, AuthorRepository repository, AuthorService authorService, LogService logService) {
        this.client = client;
        this.repository = repository;
        this.authorService = authorService;
        this.logService = logService;
    }
    @GetMapping
    public List<Author> getAuthors(@RequestParam("q") String query) {
        List<Author> authors = repository.findByAuthorName(query);
        if (authors.isEmpty()) {
              authors = authorService.fetchAndSaveAuthorsFromOpenLibrary(query) ;
        }
        logService.saveQueryAndTime(query);
        return authors;
    }
}

