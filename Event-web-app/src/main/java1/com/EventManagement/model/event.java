package com.EventManagement.model;

import java.time.LocalDateTime;

public class event {

    private Long eventId;

    public event(Long eventId, String title, String description, LocalDateTime startDate, LocalDateTime endDate,
			String location, EventType eventType, user organizer) {
		super();
		this.eventId = eventId;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.eventType = eventType;
		this.organizer = organizer;
	}

	@Override
	public String toString() {
		return "event [eventId=" + eventId + ", title=" + title + ", description=" + description + ", startDate="
				+ startDate + ", endDate=" + endDate + ", location=" + location + ", eventType=" + eventType
				+ ", organizer=" + organizer + "]";
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public user getOrganizer() {
		return organizer;
	}

	public void setOrganizer(user organizer) {
		this.organizer = organizer;
	}

	private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;

    private EventType eventType;

    private user organizer;

    public enum EventType {
        IN_PERSON, VIRTUAL, HYBRID
    }

    // Getters and setters
}
