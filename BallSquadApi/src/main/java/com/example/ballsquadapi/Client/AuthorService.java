package com.example.ballsquadapi.Client;

import com.example.ballsquadapi.AuthorResponse;
import com.example.ballsquadapi.Client.OpenLibraryClient;
import com.example.ballsquadapi.Models.Author;
import com.example.ballsquadapi.Repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final OpenLibraryClient openLibraryClient;

    public AuthorService(AuthorRepository authorRepository, OpenLibraryClient openLibraryClient) {
        this.authorRepository = authorRepository;
        this.openLibraryClient = openLibraryClient;
    }

    public Author getAuthor(String name) {
        Optional<Author> authorOptional = authorRepository.findByAuthor_Name(name);
        if (authorOptional.isPresent()) {
            return authorOptional.get();
        } else {
            AuthorResponse response = openLibraryClient.getAuthors(name);
            // Assuming that the first author in the response is the one we want
            Author author = response.getDocs().get(0);
            authorRepository.save(author);
            return author;
        }
    }
}
