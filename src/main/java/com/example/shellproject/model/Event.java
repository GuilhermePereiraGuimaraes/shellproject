package com.example.shellproject.model;

import com.example.shellproject.util.EventType;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Date;

public class Event {
    private Long id;
    private EventType type;
    private Actor actor;
    private Repo repo;
    private JsonNode payload;
    private boolean isPublic;
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public JsonNode getPayload() {
        return payload;
    }

    public void setPayload(JsonNode payload) {
        this.payload = payload;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", type=" + type +
                ", actor=" + actor +
                ", repo=" + repo +
                ", payload=" + payload +
                ", isPublic=" + isPublic +
                ", createdAt=" + createdAt +
                '}';
    }
}
