package com.example.ballsquadapi.Models;


import jakarta.persistence.*;
import java.util.Objects;
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

    public void setAuthorKey(String author_key) {
        this.authorKey = author_key;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getAuthorName() {
        return authorName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Author))
            return false;
        Author author = (Author) o;
        return Objects.equals(this.id, author.id) && Objects.equals(this.authorKey, author.authorKey)
                && Objects.equals(this.authorName, author.authorName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.authorKey, this.authorName);
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
