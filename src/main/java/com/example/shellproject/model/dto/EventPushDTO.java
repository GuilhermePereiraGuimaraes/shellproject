package com.example.shellproject.model.dto;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

public class EventPushDTO extends EventDTO {
    private Integer counter;

    public EventPushDTO() {
        counter = 1;
    }

    public EventPushDTO(String actor, EventType eventType, String repoName, JsonNode payload) {
        super(actor, eventType, repoName, payload);
        counter = 1;
    }

    public Integer getCounter() {
        return counter;
    }

    public void increment(){
        counter++;
    }

    @Override
    public String toString() {
        return "EventPushDTO{" +
                "counter=" + counter + ", "
                +super.toString() +
                '}';
    }
}
