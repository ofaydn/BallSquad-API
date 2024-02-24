package com.example.ballsquadapi.services;

import com.example.ballsquadapi.clients.OpenLibraryClient;
import com.example.ballsquadapi.dtos.authors.AuthorDoc;
import com.example.ballsquadapi.dtos.authors.AuthorResponse;
import com.example.ballsquadapi.dtos.works.AuthorWorksResponse;
import com.example.ballsquadapi.entities.Author;
import com.example.ballsquadapi.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
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
    public AuthorResponse getAuthorsFromClient(String author_name) {
        try {
            return client.getAuthors(author_name);
        } catch (Exception e) {
            System.out.println("OpenLibrary error: " + e.getMessage());
            return null;
        }
    }
    @Transactional
    public List<Author> getAuthors(String author_name) {
        List<Author> authors = repository.findByAuthorName(author_name);
        if (authors.isEmpty()) {
            authors = fetchAuthors(author_name);
        }
        return authors;
    }

    @Transactional
    public List<Author> fetchAuthors(String author_name) {
        List<Author> authors = repository.findByAuthorName(author_name);
        if (authors.isEmpty()) {
            AuthorResponse response = getAuthorsFromClient(author_name);
            for (AuthorDoc doc : response.getDocs()) {
                Author author = new Author(doc.getKey(), doc.getName());
                if (!authors.contains(author.getAuthorName())) {
                    authors.add(author);
                }
            }
            repository.saveAll(authors);
        }
        return authors;
    }
}

