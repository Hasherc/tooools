package com.qiming.tooools.model;

import javafx.event.EventType;

import java.util.HashMap;

/**
 * @tooools
 * @Description:
 * @Author: qming_c
 * @Date: 2018-02-03-21:48
 */
public class Event {
    private int id;
    private EventType eventType;
    private HashMap<String,Object> eventProperties;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventType=" + eventType +
                ", eventProperties=" + eventProperties +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public HashMap<String, Object> getEventProperties() {
        return eventProperties;
    }

    public void setEventProperties(HashMap<String, Object> eventProperties) {
        this.eventProperties = eventProperties;
    }
}
