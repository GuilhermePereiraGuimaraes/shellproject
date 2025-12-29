package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventMemberDTO extends EventDTO {
    private String action;
    private String memberName;

    public EventMemberDTO() {
    }

    public EventMemberDTO(String actor, EventType eventType, String repoName, JsonNode payload, String action, String memberName) {
        super(actor, eventType, repoName, payload);
        this.action = action;
        this.memberName = memberName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
