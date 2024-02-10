package com.example.ballsquadapi.Services;

import com.example.ballsquadapi.Client.OpenLibraryClient;
import com.example.ballsquadapi.Models.Author;
import com.example.ballsquadapi.Models.AuthorDoc;
import com.example.ballsquadapi.DTOs.AuthorResponse;
import com.example.ballsquadapi.Repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private final OpenLibraryClient client;
    private final AuthorRepository repository;

    public AuthorService(OpenLibraryClient client, AuthorRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    public List<Author> fetchAndSaveAuthorsFromOpenLibrary(String query) {
        List<Author> authors = new ArrayList<>();
        AuthorResponse response = client.getAuthors(query);
        for (AuthorDoc doc : response.getDocs()) {
            Author author = new Author(doc.getKey(), doc.getName());
            if (!repository.existsByAuthorName(author.getAuthorName())) {
                repository.save(author);
                authors.add(author);
            }
        }
        return authors;
    }
}

