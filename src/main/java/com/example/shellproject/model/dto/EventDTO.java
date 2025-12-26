package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventDTO {
    private String actor;
    private EventType eventType;
    private String repoName;
    private JsonNode payload;

    public EventDTO() {
    }

    public EventDTO(String actor, EventType eventType, String repoName, JsonNode payload) {
        this.actor = actor;
        this.eventType = eventType;
        this.repoName = repoName;
        this.payload = payload;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public JsonNode getPayload() {
        return payload;
    }

    public void setPayload(JsonNode payload) {
        this.payload = payload;
    }
}
