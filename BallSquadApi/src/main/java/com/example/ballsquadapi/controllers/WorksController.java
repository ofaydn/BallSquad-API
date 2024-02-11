package com.example.ballsquadapi.controllers;
import com.example.ballsquadapi.entities.AuthorWorks;
import com.example.ballsquadapi.services.WorkService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/works")
public class WorksController {
    private final WorkService workService;
    public WorksController(WorkService workService) {
        this.workService = workService;
    }
    @PostMapping("/{authorKey}")

    public List<AuthorWorks> getAuthorWorks(@PathVariable("authorKey") String authorKey) {
        return workService.getAuthorWorks(authorKey);
    }
}
