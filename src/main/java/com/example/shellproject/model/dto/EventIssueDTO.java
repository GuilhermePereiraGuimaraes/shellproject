package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventIssueDTO extends EventDTO{
    private String action;
    private Integer number;

    public EventIssueDTO() {
    }

    public EventIssueDTO(String actor, EventType eventType, String repoName, JsonNode payload, String action, Integer number) {
        super(actor, eventType, repoName, payload);
        this.action = action;
        this.number = number;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        String actionCapitalized = action.substring(0, 1).toUpperCase() + action.substring(1);
        return "- "+actionCapitalized+" the issue number "+number+ " in "+getRepoName();
    }
}
