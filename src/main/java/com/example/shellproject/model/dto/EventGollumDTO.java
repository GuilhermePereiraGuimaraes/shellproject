package com.example.shellproject.model.dto;

public class EventGollumDTO extends EventDTO{

    @Override
    public String toString() {
        return "- Gollum wiki created to "+getRepoName();
    }
}
