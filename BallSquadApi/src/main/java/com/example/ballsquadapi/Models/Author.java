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
    private Long id;
    @Column(name = "author_key")
    private String author_key;

    @Column(name = "author_type")
    private String author_type;
    @Column(name = "author_name")
    private String author_name;
    @Column(name = "birth_date")
    private String birth_date;
    @Column(name = "top_work")
    private String top_work;
    @Column(name = "work_count")
    private int work_count;
    @Column(name = "_version_")
    private long _version_;

    public Author() {}

    public String getAuthorName() {
        return author_name;
    }
    public Author(String author_key, String author_type, String authorName, String birth_date, String top_work, int work_count, long _version_) {
        this.author_key = author_key;
        this.author_type = author_type;
        this.author_name = authorName;
        this.birth_date = birth_date;
        this.top_work = top_work;
        this.work_count = work_count;
        this._version_ = _version_;
    }

    // getters and setters

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Author))
            return false;
        Author author = (Author) o;
        return Objects.equals(this.id, author.id) && Objects.equals(this.author_key, author.author_key)
                && Objects.equals(this.author_type, author.author_type) && Objects.equals(this.author_name, author.author_name)
                && Objects.equals(this.birth_date, author.birth_date) && Objects.equals(this.top_work, author.top_work)
                && Objects.equals(this.work_count, author.work_count) && Objects.equals(this._version_, author._version_);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.author_key, this.author_type, this.author_name, this.birth_date, this.top_work, this.work_count, this._version_);
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + this.id + ", key='" + this.author_key + '\'' + ", type='" + this.author_type + '\'' + ", name='" + this.author_name + '\'' + ", birth_date='" + this.birth_date + '\'' + ", top_work='" + this.top_work + '\'' + ", work_count=" + this.work_count + ", _version_=" + this._version_ + '}';
    }
}
