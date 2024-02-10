package com.example.ballsquadapi.Models;
import jakarta.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "query_logs")
public class LogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    public Timestamp getTime() {
        return time;
    }
    public void setTime(Timestamp time) {
        this.time = time;
    }
    public String getQuery() {
        return query;
    }
    @Column(name = "timestamp")
    private Timestamp time;
    @Column(name = "query")
    private String query;

    public void setQuery(String query) {
        this.query = query;
    }
    public void setTime(Time time) {
        this.time = Timestamp.valueOf(LocalDateTime.now());
    }


}
