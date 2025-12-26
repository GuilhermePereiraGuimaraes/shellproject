package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventCreateDTO extends EventDTO{

    private String ref;
    private String refType;

    public EventCreateDTO() {
    }

    public EventCreateDTO(String actor, EventType eventType, String repoName, JsonNode payload, String ref , String refType) {
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
}
