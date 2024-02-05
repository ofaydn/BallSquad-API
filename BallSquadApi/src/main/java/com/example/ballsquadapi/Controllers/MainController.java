package com.example.ballsquadapi.Controllers;

import com.example.ballsquadapi.Models.Author;
import com.example.ballsquadapi.Client.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class MainController {

    private final AuthorService authorService;

    public MainController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public Author getAuthor(@RequestParam("q") String name) {
        return authorService.getAuthor(name);
    }
}

