package com.example.ballsquadapi.controllers;
import com.example.ballsquadapi.entities.Author;
import com.example.ballsquadapi.services.AuthorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping

    public List<Author> getAuthors(@RequestParam("name") String author_name) {
        return authorService.getAuthors(author_name);
    }
}

