package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventForkDTO extends EventDTO {

    public EventForkDTO() {
    }

    public EventForkDTO(String actor, EventType eventType, String repoName, JsonNode payload) {
        super(actor, eventType, repoName, payload);
    }

    @Override
    public String toString() {
        return "- Forked the repository "+getRepoName();
    }
}
