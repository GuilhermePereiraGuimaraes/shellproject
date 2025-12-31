package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventCommitCommentDTO extends EventDTO{

    public EventCommitCommentDTO() {
    }

    public EventCommitCommentDTO(String actor, EventType eventType, String repoName, JsonNode payload) {
        super(actor, eventType, repoName, payload);
    }

    @Override
    public String toString() {
        return "- Commit a Comment to "+getRepoName();
    }
}
