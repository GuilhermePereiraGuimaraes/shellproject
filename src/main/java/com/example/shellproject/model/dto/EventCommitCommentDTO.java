package com.example.shellproject.model.dto;

public class EventCommitCommentDTO extends EventDTO{

    @Override
    public String toString() {
        return "- Commit a Comment to "+getRepoName();
    }
}
