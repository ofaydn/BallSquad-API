package com.example.ballsquadapi.entities;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "author_key")
    private String authorKey;

    @Column(name = "author_name")
    private String authorName;

    public Author() {}
    public Author(String authorKey, String authorName) {
        this.authorKey = authorKey;
        this.authorName = authorName;
    }
    public String getAuthorKey() {
        return authorKey;
    }
    public void setAuthorKey(String authorKey) {
        this.authorKey = authorKey;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getAuthorName() {
        return authorName;
    }
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", author_key='" + authorKey + '\'' +
                ", author_name='" + authorName + '\'' +
                '}';
    }

}
