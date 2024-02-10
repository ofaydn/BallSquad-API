package com.example.ballsquadapi.Repositories;

import com.example.ballsquadapi.Models.AuthorWorks;
import com.example.ballsquadapi.Models.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<LogEntry, Long> {

}