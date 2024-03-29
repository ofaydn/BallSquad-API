package com.ballsquadapi.controllers;
import com.ballsquadapi.entities.AuthorWorks;
import com.ballsquadapi.services.WorkService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/works")
public class WorksController {
    private final WorkService workService;
    public WorksController(WorkService workService) {
        this.workService = workService;
    }
    @PostMapping("/{authorKey}")

    public List<AuthorWorks> getAuthorWorks(@PathVariable("authorKey") String authorKey) {
        if(Objects.equals(authorKey, "")) {
            return null;
        }
        return workService.getAuthorWorks(authorKey);
    }
}
