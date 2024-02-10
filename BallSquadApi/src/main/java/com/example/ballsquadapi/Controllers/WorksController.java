package com.example.ballsquadapi.Controllers;

import com.example.ballsquadapi.Client.OpenLibraryClient;
import com.example.ballsquadapi.Models.AuthorWorks;
import com.example.ballsquadapi.Repositories.AuthorWorkRepository;
import com.example.ballsquadapi.Services.WorkService;
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
    private final WorkService workService;

    public WorksController(OpenLibraryClient client, AuthorWorkRepository workRepository, WorkService workService) {
        this.client = client;
        this.workRepository = workRepository;
        this.workService = workService;
    }

    @GetMapping("/{authorKey}/works.json")
    public List<AuthorWorks> getAuthorWorks(@PathVariable("authorKey") String authorKey) {
        return workService.fetchAndSaveAuthorWorks(authorKey);
    }
}
