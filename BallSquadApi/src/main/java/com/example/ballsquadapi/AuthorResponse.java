package com.example.ballsquadapi;

import com.example.ballsquadapi.Models.Author;

import java.util.List;

public class AuthorResponse {

    private int numFound;
    private int start;
    private boolean numFoundExact;

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public boolean isNumFoundExact() {
        return numFoundExact;
    }

    public void setNumFoundExact(boolean numFoundExact) {
        this.numFoundExact = numFoundExact;
    }

    public List<Author> getDocs() {
        return docs;
    }

    public void setDocs(List<Author> docs) {
        this.docs = docs;
    }

    private List<Author> docs;

}
