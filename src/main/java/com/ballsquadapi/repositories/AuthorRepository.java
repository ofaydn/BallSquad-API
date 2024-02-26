package com.ballsquadapi.repositories;
import com.ballsquadapi.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByAuthorName(String name);
    boolean existsByAuthorName(String name);
}
