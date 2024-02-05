package com.example.ballsquadapi.Repositories;

import com.example.ballsquadapi.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByAuthor_Name(String authorName);
}
