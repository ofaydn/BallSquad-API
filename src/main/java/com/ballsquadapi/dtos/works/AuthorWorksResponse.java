package com.ballsquadapi.dtos.works;
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


