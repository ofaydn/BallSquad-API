package com.example.ballsquadapi.dtos.authors;

public class AuthorDoc {
    private String authorKey;
    private String authorName;
    public AuthorDoc(String authorKey, String authorName) {
        this.authorKey = authorKey;
        this.authorName = authorName;
    }
    public String getAuthorKey() {
        return authorKey;
    }
    public void setAuthorKey(String authorKey) {
        this.authorKey = authorKey;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
