package com.example.shellproject.model.mapper;

import com.example.shellproject.model.Event;
import com.example.shellproject.model.dto.*;

public class EventMapper {

    public static EventDTO toDTO(Event event) {
        return new EventDTO(event.getActor().getLogin(), event.getType(), event.getRepo().getName(), event.getPayload());
    }

    public static EventCreateDTO toCreateDTO(Event event) {
        return new EventCreateDTO(event.getActor().getLogin(), event.getType(), event.getRepo().getName(), event.getPayload(), event.getPayload().path("ref").asText(null),event.getPayload().path("ref_type").asText());
    }

    public static EventCommitCommentDTO toEventCommitCommentDTO(EventDTO event){
        return new EventCommitCommentDTO(event.getActor(), event.getEventType(), event.getRepoName() ,event.getPayload());
    }


    public static EventCreateDTO toDTOForCreateDTO(EventDTO event) {
        return new EventCreateDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload(), event.getPayload().path("ref").asText(null),event.getPayload().path("ref_type").asText());
    }

    public static EventDeleteDTO toDTOForDeleteDTO(EventDTO event) {
        return new EventDeleteDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload(), event.getPayload().path("ref").asText(null),event.getPayload().path("ref_type").asText());
    }

    public static EventDiscussionDTO toDTOforEventDiscussionDTO(EventDTO event) {
        return new EventDiscussionDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload());
    }

    public static EventForkDTO toDTOforEventForkDTO(EventDTO event) {
        return new EventForkDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload());
    }

    public static EventGollumDTO toDTOforEventGollumDTO(EventDTO event) {
        return new EventGollumDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload());
    }

    public static EventIssueCommentDTO toDTOForIssueCommentDTO(EventDTO event) {
        return new EventIssueCommentDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload(),Integer.parseInt(event.getPayload().path("issue").path("number").asText(null)));

    }

    public static EventIssueDTO  toDTOForIssueDTO(EventDTO event) {
        return new EventIssueDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload(), event.getPayload().path("action").asText(null),Integer.parseInt(event.getPayload().path("issue").path("number").asText(null)));
    }

    public static EventMemberDTO  toDTOForMemberDTO(EventDTO event) {
        return new EventMemberDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload(), event.getPayload().path("action").asText(null),event.getPayload().path("member").path("login").asText(null));
    }

    public static EventPublicDTO toDTOForPublicDTO(EventDTO event) {
        return new EventPublicDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload());
    }

    public static EventPullRequestDTO toDTOForPullRequestDTO(EventDTO event) {
        return new EventPullRequestDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload(), event.getPayload().path("action").asText(null),Integer.parseInt(event.getPayload().path("number").asText(null)));
    }

    public static EventPullRequestReviewCommentDTO toDTOForPullRequestReviewCommentDTO(EventDTO event) {
        return new EventPullRequestReviewCommentDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload(), event.getPayload().path("action").asText(null),Integer.parseInt(event.getPayload().path("pull_request").path("number").asText(null)));
    }

    public static EventPullRequestReviewDTO toDTOForPullRequestReviewDTO(EventDTO event) {
        return new EventPullRequestReviewDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload(), event.getPayload().path("action").asText(null),Integer.parseInt(event.getPayload().path("pull_request").path("number").asText(null)));
    }

    public static EventPushDTO toDTOForPushDTO(EventDTO event) {
        return new EventPushDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload());
    }

    public static EventReleaseDTO toDTOForReleaseDTO(EventDTO event) {
        return new EventReleaseDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload(), event.getPayload().path("action").asText(null), event.getPayload().path("release").path("tag_name").asText(null));
    }

    public static EventWatchDTO toDTOForWatchDTO(EventDTO event) {
        return new EventWatchDTO(event.getActor(), event.getEventType(), event.getRepoName(), event.getPayload());
    }
}
