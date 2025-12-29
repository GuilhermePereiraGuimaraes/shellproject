package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventIssueDTO extends EventDTO{
    private String action;

    public EventIssueDTO() {
    }

    public EventIssueDTO(String actor, EventType eventType, String repoName, JsonNode payload, String action) {
        super(actor, eventType, repoName, payload);
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
