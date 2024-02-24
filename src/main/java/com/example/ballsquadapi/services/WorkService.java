package com.example.ballsquadapi.services;

import com.example.ballsquadapi.clients.OpenLibraryClient;
import com.example.ballsquadapi.dtos.works.AuthorWorksResponse;
import com.example.ballsquadapi.entities.AuthorWorks;
import com.example.ballsquadapi.dtos.works.WorksEntry;
import com.example.ballsquadapi.repositories.AuthorWorkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkService {
    private final OpenLibraryClient client;
    private final AuthorWorkRepository workRepository;
    public WorkService(OpenLibraryClient client, AuthorWorkRepository repository) {
        this.client = client;
        this.workRepository = repository;
    }

    public List<AuthorWorks> getAuthorWorks(String authorKey) {
        List<AuthorWorks> existingWorks = workRepository.findByAuthorKey(authorKey);
        if (existingWorks.isEmpty()) {
            List<AuthorWorks> newWorks = fetchAndSaveNewWorks(authorKey);
            existingWorks.addAll(newWorks);
        }
        return existingWorks;
    }

    private List<AuthorWorks> fetchAndSaveNewWorks(String authorKey) {
        AuthorWorksResponse response = getAuthorWorksResponse(authorKey);
        List<AuthorWorks> newWorks = new ArrayList<>();
        for (WorksEntry entry : response.getEntries()) {
            AuthorWorks work = new AuthorWorks();
            work.setAuthorKey(authorKey);
            work.setAuthorWork(entry.getTitle());
            newWorks.add(work);
        }
        workRepository.saveAll(newWorks);
        return newWorks;
    }

    private AuthorWorksResponse getAuthorWorksResponse(String authorKey) {
        try {
            return client.getAuthorWorks(authorKey);
        } catch (Exception e) {
            System.out.println("OpenLibrary error: " + e.getMessage());
            return null;
        }
    }


}
