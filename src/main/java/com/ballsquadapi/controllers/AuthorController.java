package com.ballsquadapi.controllers;
import com.ballsquadapi.entities.Author;
import com.ballsquadapi.services.AuthorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping

    public List<Author> getAuthors(@RequestParam("name") String authorName) {
        if(Objects.equals(authorName, "")) {
            return null;
        }
        return authorService.getAuthors(authorName);
    }
}

