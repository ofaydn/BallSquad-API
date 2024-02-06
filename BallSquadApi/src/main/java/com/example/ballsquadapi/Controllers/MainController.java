package com.example.ballsquadapi.Controllers;

import com.example.ballsquadapi.Client.OpenLibraryClient;
import com.example.ballsquadapi.Models.Author;
import com.example.ballsquadapi.Models.AuthorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class MainController {

    private final OpenLibraryClient client;

    public MainController(OpenLibraryClient client) {
        this.client = client;
    }
    @GetMapping
    public AuthorResponse getAuthors(@RequestParam("q") String query) {
        return client.getAuthors(query);
    }
}

