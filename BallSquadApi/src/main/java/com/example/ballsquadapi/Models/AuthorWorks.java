package com.example.ballsquadapi.Models;

import jakarta.persistence.*;

@Entity
public class AuthorWorks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "author_key")
    private String authorKey;

    @Column(name = "author_work")
    private String authorWork;

    public String getAuthorKey() {
        return authorKey;
    }
    public void setAuthorKey(String authorKey) {
        this.authorKey = authorKey;
    }
    public String getAuthorWork() {
        return authorWork;
    }
    public void setAuthorWork(String authorWork) {
        this.authorWork = authorWork;
    }
}
