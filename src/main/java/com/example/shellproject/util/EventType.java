package com.example.shellproject.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EventType {
    @JsonProperty("PushEvent") PUSH,
    @JsonProperty("PullRequestEvent") PULL_REQUEST,
    @JsonProperty("IssuesEvent") ISSUES,
    @JsonProperty("WatchEvent") WATCH,
    @JsonProperty("CreateEvent") CREATE,
    @JsonProperty("DeleteEvent") DELETE,
    @JsonProperty("ForkEvent") FORK,
    @JsonProperty("MemberEvent") MEMBER,
    @JsonProperty("PublicEvent") PUBLIC,
    @JsonProperty("ReleaseEvent") RELEASE,
    @JsonProperty("GollumEvent") GOLLUM,
    @JsonProperty("IssueCommentEvent") ISSUE_COMMENT,
    @JsonProperty("PullRequestReviewEvent") PULL_REQUEST_REVIEW,
    @JsonProperty("PullRequestReviewCommentEvent") PULL_REQUEST_REVIEW_COMMENT,
    @JsonProperty("DiscussionEvent") DISCUSSION;
}

