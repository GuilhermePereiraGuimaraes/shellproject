package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventIssueCommentDTO extends EventDTO{
    private Integer issueNumber;

    public EventIssueCommentDTO() {
    }

    public EventIssueCommentDTO(String actor, EventType eventType, String repoName, JsonNode payload, Integer issueNumber) {
        super(actor, eventType, repoName, payload);
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return "- Commented the issue number "+issueNumber+" in "+getRepoName();
    }
}
