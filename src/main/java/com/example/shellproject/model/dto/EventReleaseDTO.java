package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventReleaseDTO extends EventDTO {
    private String action;
    private String tagName;

    public EventReleaseDTO() {
    }

    public EventReleaseDTO(String actor, EventType eventType, String repoName, JsonNode payload, String action, String tagName) {
        super(actor, eventType, repoName, payload);
        this.action = action;
        this.tagName = tagName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
