package com.example.ballsquadapi.Services;

import com.example.ballsquadapi.Client.OpenLibraryClient;
import com.example.ballsquadapi.DTOs.AuthorWorksResponse;
import com.example.ballsquadapi.Models.AuthorWorks;
import com.example.ballsquadapi.Models.WorksEntry;
import com.example.ballsquadapi.Repositories.AuthorWorkRepository;
import org.springframework.stereotype.Service;

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

    public List<AuthorWorks> fetchAndSaveAuthorWorks(String authorKey) {
        List<AuthorWorks> works = new ArrayList<>();
        List<AuthorWorks> existingWorks = workRepository.findByAuthorKey(authorKey);
        if (existingWorks.isEmpty()) {
            AuthorWorksResponse response = client.getAuthorWorks(authorKey);
            for (WorksEntry entry : response.getEntries()) {
                AuthorWorks work = new AuthorWorks();
                work.setAuthorKey(authorKey);
                work.setAuthorWork(entry.getTitle());
                works.add(work);
                workRepository.save(work);
            }
        } else {
            works.addAll(existingWorks);
        }
        return works;
    }

}
