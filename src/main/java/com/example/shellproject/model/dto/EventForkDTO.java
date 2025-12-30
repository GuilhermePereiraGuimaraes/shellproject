package com.example.shellproject.model.dto;

public class EventForkDTO extends EventDTO {
    @Override
    public String toString() {
        return "- Forked the repository "+getRepoName();
    }
}
