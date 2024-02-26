package com.ballsquadapi.repositories;

import com.ballsquadapi.entities.AuthorWorks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorWorkRepository extends JpaRepository<AuthorWorks, Long> {
    List<AuthorWorks> findByAuthorKey(String authorKey);
    boolean existsByAuthorKey(String key);
}
