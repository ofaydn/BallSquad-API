package com.example.ballsquadapi.Controllers;

import com.example.ballsquadapi.Client.OpenLibraryClient;
import com.example.ballsquadapi.Models.AuthorWorks;
import com.example.ballsquadapi.Models.AuthorWorksResponse;
import com.example.ballsquadapi.Models.WorksEntry;
import com.example.ballsquadapi.Repositories.AuthorRepository;
import com.example.ballsquadapi.Repositories.AuthorWorkRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class WorksController {

    // ...

    private final AuthorWorkRepository workRepository;
    private final OpenLibraryClient client;
    private final AuthorRepository repository;

    public WorksController(OpenLibraryClient client, AuthorRepository repository, AuthorWorkRepository workRepository) {
        this.client = client;
        this.repository = repository;
        this.workRepository = workRepository;
    }

    @GetMapping("/{authorKey}/works.json")
    public List<AuthorWorks> getAuthorWorks(@PathVariable("authorKey") String authorKey) {
        List<AuthorWorks> works = workRepository.findByAuthorKey(authorKey);
        if (works.isEmpty()) {
            AuthorWorksResponse response = client.getAuthorWorks(authorKey);
            for (WorksEntry entry : response.getEntries()) {
                AuthorWorks work = new AuthorWorks();
                work.setAuthorKey(authorKey);
                work.setAuthorWork(entry.getTitle());
                works.add(work);
                workRepository.save(work);
            }
        }
        return works;
    }
}
