package com.example.shellproject.model.dto;

public class EventPublicDTO extends EventDTO {
    @Override
    public String toString() {
        return "- Published the repository "+getRepoName();
    }
}
