package com.example.ballsquadapi.Client;

import com.example.ballsquadapi.DTOs.AuthorResponse;
import com.example.ballsquadapi.DTOs.AuthorWorksResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openLibraryClient", url = "https://openlibrary.org")
public interface OpenLibraryClient {

    @GetMapping("/search/authors.json")
    AuthorResponse getAuthors(@RequestParam("q") String query);

    @GetMapping("/authors/{authorKey}/works.json")

    AuthorWorksResponse getAuthorWorks(@PathVariable("authorKey") String authorKey);
}


