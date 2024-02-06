package com.example.ballsquadapi.Models;

import java.util.List;

public class AuthorResponse {
    private int numFound;
    private int start;
    private boolean numFoundExact;
    private List<AuthorDoc> docs;
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

    public List<AuthorDoc> getDocs() {
        return docs;
    }

    public void setDocs(List<AuthorDoc> docs) {
        this.docs = docs;
    }



}
