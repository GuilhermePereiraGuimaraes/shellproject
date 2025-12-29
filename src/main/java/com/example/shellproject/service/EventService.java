package com.example.shellproject.service;

import com.example.shellproject.model.dto.EventDTO;
import com.example.shellproject.model.dto.EventPushDTO;
import com.example.shellproject.model.mapper.EventMapper;
import com.example.shellproject.util.EventType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EventService {

    private static String keyOf(EventPushDTO e) {
        return e.getActor() + "|" + e.getEventType() + "|" + e.getRepoName();
    }

    public List<String> transFromDTO(List<EventDTO> dtos){
        ArrayList<String> list = new ArrayList<>();
        Map<String, EventPushDTO> map = dtos
                .stream().filter(eventDTO -> eventDTO.getEventType() == EventType.PUSH)
                .toList()
                .stream().map(EventMapper::toDTOForPushDTO)
                .toList()
                .stream()
                .collect(Collectors.toMap(
                    EventService::keyOf,
                        e -> {
                            EventPushDTO copy = new EventPushDTO(e.getActor(), e.getEventType(), e.getRepoName(), e.getPayload());
                            return copy;
                        },
                        (acc, dup) -> {
                            acc.increment();
                            return acc;
                        },
                        LinkedHashMap::new
                ));

        List<EventPushDTO> pushEvents = new ArrayList<>(map.values());

        dtos = dtos.stream().filter(eventDTO -> eventDTO.getEventType() != EventType.PUSH).toList();



//        for(EventDTO dto : dtos){
//
//        }
        return pushEvents.stream().map(EventPushDTO::toString).toList();
    }

}
