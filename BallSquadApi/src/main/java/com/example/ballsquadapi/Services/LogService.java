package com.example.ballsquadapi.Services;

import com.example.ballsquadapi.Models.LogEntry;
import com.example.ballsquadapi.Repositories.LogRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class LogService {
    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void saveQueryAndTime(String query) {
        LogEntry logEntry = new LogEntry();
        logEntry.setQuery(query);
        logEntry.setTime(Timestamp.valueOf(LocalDateTime.now()));
        logRepository.save(logEntry);
    }
}
