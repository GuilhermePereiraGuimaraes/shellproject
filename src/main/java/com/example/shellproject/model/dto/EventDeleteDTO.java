package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventDeleteDTO extends EventDTO{

    private String ref;
    private String refType;

    public EventDeleteDTO() {
    }

    public EventDeleteDTO(String actor, EventType eventType, String repoName, JsonNode payload, String ref , String refType) {
        super(actor, eventType, repoName, payload);
        this.ref = ref;
        this.refType = refType;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    @Override
    public String toString() {
        String conditionalText = getRefType().equals("repository") ? "the " + getRefType() + " " : "a "+ getRefType()+" to";
        return "- Deleted "+conditionalText+" "+getRepoName();
    }
}
