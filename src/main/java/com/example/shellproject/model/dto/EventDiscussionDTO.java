package com.example.shellproject.model.dto;

public class EventDiscussionDTO extends EventDTO {
    @Override
    public String toString() {
        return "- Discussion created in "+getRepoName();
    }
}
