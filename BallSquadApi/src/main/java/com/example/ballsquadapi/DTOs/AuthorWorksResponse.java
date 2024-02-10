package com.example.ballsquadapi.DTOs;
import com.example.ballsquadapi.Models.WorksEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorWorksResponse {
    @JsonProperty("entries")
    private List<WorksEntry> entries;
    public List<WorksEntry> getEntries() {
        return entries;
    }
    public void setEntries(List<WorksEntry> entries) {
        this.entries = entries;
    }

}


