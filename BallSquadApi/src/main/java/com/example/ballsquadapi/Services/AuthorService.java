package com.example.ballsquadapi.Services;

import com.example.ballsquadapi.Client.OpenLibraryClient;
import com.example.ballsquadapi.Models.Author;
import com.example.ballsquadapi.Models.AuthorDoc;
import com.example.ballsquadapi.Models.AuthorResponse;
import com.example.ballsquadapi.Repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final OpenLibraryClient client;
    private final AuthorRepository repository;

    public AuthorService(OpenLibraryClient client, AuthorRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    public void fetchAndSaveAuthors(String query) {
        AuthorResponse response = client.getAuthors(query);
        for (AuthorDoc doc : response.getDocs()) {
            Author author = new Author(doc.getKey(), doc.getName());
            repository.save(author);
        }
    }
}
