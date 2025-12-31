package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventPublicDTO extends EventDTO {

    public EventPublicDTO() {
    }

    public EventPublicDTO(String actor, EventType eventType, String repoName, JsonNode payload) {
        super(actor, eventType, repoName, payload);
    }

    @Override
    public String toString() {
        return "- Published the repository "+getRepoName();
    }
}
