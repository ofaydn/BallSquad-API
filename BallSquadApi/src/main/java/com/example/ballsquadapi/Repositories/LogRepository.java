package com.example.ballsquadapi.Repositories;
import com.example.ballsquadapi.Models.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LogRepository extends JpaRepository<LogEntry, Long> {

}