package com.example.ballsquadapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorksEntry {

    @JsonProperty("title")
    private String title;

    // getters
    public String getTitle() {
        return title;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }
}