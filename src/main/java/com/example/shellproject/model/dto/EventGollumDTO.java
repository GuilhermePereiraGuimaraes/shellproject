package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventGollumDTO extends EventDTO{

    public EventGollumDTO() {
    }

    public EventGollumDTO(String actor, EventType eventType, String repoName, JsonNode payload) {
        super(actor, eventType, repoName, payload);
    }

    @Override
    public String toString() {
        return "- Gollum wiki created to "+getRepoName();
    }
}
