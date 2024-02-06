package com.example.ballsquadapi.Controllers;

import com.example.ballsquadapi.Client.OpenLibraryClient;
import com.example.ballsquadapi.Models.Author;
import com.example.ballsquadapi.Models.AuthorDoc;
import com.example.ballsquadapi.Models.AuthorResponse;
import com.example.ballsquadapi.Repositories.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class MainController {

    private final OpenLibraryClient client;
    private  final AuthorRepository repository;

    public MainController(OpenLibraryClient client, AuthorRepository repository) {
        this.client = client;
        this.repository = repository;
    }
    @GetMapping
    public List<Author> getAuthors(@RequestParam("q") String query) {
        List<Author> authors = repository.findByAuthorName(query);
        if (authors.isEmpty()) {
            AuthorResponse response = client.getAuthors(query);
            if (response.getNumFound() > 0) {
                for(AuthorDoc doc : response.getDocs()) {
                    Author author = new Author(doc.getKey(), doc.getName());
                    authors.add(author);
                    repository.save(author);
                }
            }
        }

        return authors;
    }


}

