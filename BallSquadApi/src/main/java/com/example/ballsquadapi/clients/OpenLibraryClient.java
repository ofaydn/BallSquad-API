package com.example.ballsquadapi.clients;
import com.example.ballsquadapi.dtos.authors.AuthorResponse;
import com.example.ballsquadapi.dtos.works.AuthorWorksResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openLibraryClient", url = "https://openlibrary.org")
public interface OpenLibraryClient {
    @GetMapping("/search/authors.json")
    AuthorResponse getAuthors(@RequestParam("q") String author_name);

    @GetMapping("/authors/{authorKey}/works.json")
    AuthorWorksResponse getAuthorWorks(@PathVariable("authorKey") String author_key);
}


