package dz.univconstantineii.archlog.lightmanager.system.events;

import dz.univconstantineii.archlog.lightmanager.model.enums.EventType;
import dz.univconstantineii.archlog.lightmanager.model.enums.LampeEventType;

import java.util.Date;
import java.util.LinkedList;

public class LampeEvent {
    LampeEventType lampeEventType;
    EventType eventType;
    Date dateTime;

    public LampeEvent(LampeEventType lampeEventType, EventType eventType, Date dateTime) {
        this.lampeEventType = lampeEventType;
        this.eventType = eventType;
        this.dateTime = dateTime;
    }

    public LampeEventType getLampeEventType() {
        return lampeEventType;
    }

    public void setLampeEventType(LampeEventType lampeEventType) {
        this.lampeEventType = lampeEventType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
