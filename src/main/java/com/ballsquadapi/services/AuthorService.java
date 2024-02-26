package com.ballsquadapi.services;
import com.ballsquadapi.clients.OpenLibraryClient;
import com.ballsquadapi.dtos.authors.AuthorDoc;
import com.ballsquadapi.dtos.authors.AuthorResponse;
import com.ballsquadapi.entities.Author;
import com.ballsquadapi.repositories.AuthorRepository;
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
    public AuthorResponse getAuthorsFromClient(String authorName) {
        try {
            return client.getAuthors(authorName);
        } catch (Exception e) {
            System.out.println("OpenLibrary error: " + e.getMessage());
            return null;
        }
    }
    @Transactional
    public List<Author> getAuthors(String authorName) {
        List<Author> authors = repository.findByAuthorName(authorName);
        if (authors.isEmpty()) {
            authors = fetchAuthors(authorName);
        }
        return authors;
    }

    @Transactional
    public List<Author> fetchAuthors(String authorName) {
        List<Author> fetchAuthorList = new ArrayList<>();
        AuthorResponse response = getAuthorsFromClient(authorName);
        for (AuthorDoc doc : response.getDocs()) {
            Author author = new Author(doc.getKey(), doc.getName());
            if (!fetchAuthorList.contains(author.getAuthorName())) {
                fetchAuthorList.add(author);
            }
        }
        repository.saveAll(fetchAuthorList);
        return fetchAuthorList;
    }
}

