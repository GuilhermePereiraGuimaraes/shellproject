package com.example.shellproject.model.mapper;

import com.example.shellproject.model.Event;
import com.example.shellproject.model.dto.EventCreateDTO;
import com.example.shellproject.model.dto.EventDTO;

public class EventMapper {

    public static EventDTO toDTO(Event event) {
        return new EventDTO(event.getActor().getLogin(), event.getType(), event.getRepo().getName(), event.getPayload());
    }

    public static EventCreateDTO  toCreateDTO(Event event) {
        return new EventCreateDTO(event.getActor().getLogin(), event.getType(), event.getRepo().getName(), event.getPayload(), event.getPayload().path("ref").asText(null),event.getPayload().path("ref_type").asText());
    }
    public static EventCreateDTO toDTOForCreateDTO(EventDTO event) {
        return new EventCreateDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload(), event.getPayload().path("ref").asText(null),event.getPayload().path("ref_type").asText());
    }
}
