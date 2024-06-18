package org.example.model;

import java.sql.Timestamp;

public class Event {
    long timestamp;
    EventType eventType;
    String clientID;

    public Event(long timestamp, EventType eventType, String clientID) {
        this.timestamp = timestamp;
        this.eventType = eventType;
        this.clientID = clientID;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }
}
