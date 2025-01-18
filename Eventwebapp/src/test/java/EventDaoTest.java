import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

package com.eventmanagement.dao;

import com.eventmanagement.model.Event;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventDAOTest {

    private EventDAO eventDAO;
    private Event event;

    @BeforeEach
    void setUp() {
        eventDAO = new EventDAO();
        event = new Event();
        event.setName("Test Event");
        event.setLocation("Test Location");
        event.setDate("2025-01-01");
    }

    @AfterEach
    void tearDown() {
        if (event != null && event.getId() != null) {
            eventDAO.findEventById(event.getId());
            eventDAO.close();
        }
    }

    @Test
    void testSaveEvent() {
        eventDAO.saveEvent(event);
        assertNotNull(event.getId(), "Event ID should not be null after saving");
    }

    @Test
    void testFindEventById() {
        eventDAO.saveEvent(event);
        Event foundEvent = eventDAO.findEventById(event.getId());
        assertNotNull(foundEvent, "Event should be found by ID");
        assertEquals(event.getName(), foundEvent.getName(), "Event name should match");
        assertEquals(event.getLocation(), foundEvent.getLocation(), "Event location should match");
    }
}

