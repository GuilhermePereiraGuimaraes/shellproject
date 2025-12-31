package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventWatchDTO extends EventDTO{

    public EventWatchDTO() {
    }

    public EventWatchDTO(String actor, EventType eventType, String repoName, JsonNode payload) {
        super(actor, eventType, repoName, payload);
    }

    @Override
    public String toString() {
        return "- Starred the repository named "+getRepoName();
    }
}
