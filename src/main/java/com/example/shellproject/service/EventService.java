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
        ArrayList<EventDTO> list = new ArrayList<>();
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

        list.addAll(new ArrayList<>(map.values()));

        dtos = dtos.stream()
                .filter(eventDTO -> eventDTO.getEventType() != EventType.PUSH)
                .toList();

        for(EventDTO dto : dtos){

            switch (dto.getEventType()){
                case PUSH ->  list.add(EventMapper.toDTOForPushDTO(dto));
                case PULL_REQUEST -> list.add(EventMapper.toDTOForPullRequestDTO(dto));
                case ISSUES -> list.add(EventMapper.toDTOForIssueDTO(dto));
                case CREATE ->  list.add(EventMapper.toDTOForCreateDTO(dto));
                case DELETE -> list.add(EventMapper.toDTOForDeleteDTO(dto));
                case ISSUE_COMMENT -> list.add(EventMapper.toDTOForIssueCommentDTO(dto));
                case GOLLUM -> list.add(EventMapper.toDTOforEventGollumDTO(dto));
                case MEMBER -> list.add(EventMapper.toDTOForMemberDTO(dto));
                case PUBLIC -> list.add(EventMapper.toDTOForPublicDTO(dto));
                case RELEASE -> list.add(EventMapper.toDTOForReleaseDTO(dto));
                case PULL_REQUEST_REVIEW -> list.add(EventMapper.toDTOForPullRequestReviewDTO(dto));
                case PULL_REQUEST_REVIEW_COMMENT -> list.add(EventMapper.toDTOForPullRequestReviewCommentDTO(dto));
                case FORK -> list.add(EventMapper.toDTOforEventForkDTO(dto));
                case WATCH -> list.add(EventMapper.toDTOForWatchDTO(dto));
                case DISCUSSION -> list.add(EventMapper.toDTOforEventDiscussionDTO(dto));
                default -> {
                    list.add(dto);
                }
            }

        }

        return list.stream().map(EventDTO::toString).toList();
    }

}
