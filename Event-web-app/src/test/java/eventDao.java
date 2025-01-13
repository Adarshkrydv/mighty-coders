import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import java.util.*;

public class EventDaoTest {

    @Test
    public void testSaveEvent() {
        Event event = mock(Event.class);
        eventDao eventDao = mock(eventDao.class);

        when(eventDao.save(event)).thenReturn(event);

        Event savedEvent = eventDao.save(event);

        assertNotNull(savedEvent);
        verify(eventDao, times(1)).save(event);
    }

    @Test
    public void testFindById() {
        Long eventId = 1L;
        Event event = mock(Event.class);
        eventDao eventDao = mock(eventDao.class);

        when(eventDao.findById(eventId)).thenReturn(event);

        Event foundEvent = eventDao.findById(eventId);

        assertNotNull(foundEvent);
        assertEquals(event, foundEvent);
    }

    @Test
    public void testFindByCategory() {
        EventCategory category = EventCategory.CONCERT; // Assuming EventCategory is an enum
        List<Event> events = new ArrayList<>();
        Event event = mock(Event.class);
        events.add(event);
        eventDao eventDao = mock(eventDao.class);

        when(eventDao.findByCategory(category)).thenReturn(events);

        List<Event> foundEvents = eventDao.findByCategory(category);

        assertNotNull(foundEvents);
        assertEquals(1, foundEvents.size());
        assertEquals(event, foundEvents.get(0));
    }

    @Test
    public void testFindUpcomingEvents() {
        java.util.Date date = new java.util.Date();
        List<Event> events = new ArrayList<>();
        Event event = mock(Event.class);
        events.add(event);
        eventDao eventDao = mock(eventDao.class);

        when(eventDao.findUpcomingEvents(date)).thenReturn(events);

        List<Event> foundEvents = eventDao.findUpcomingEvents(date);

        assertNotNull(foundEvents);
        assertEquals(1, foundEvents.size());
        assertEquals(event, foundEvents.get(0));
    }

    @Test
    public void testFindByName() {
        String name = "Tech Conference";
        List<Event> events = new ArrayList<>();
        Event event = mock(Event.class);
        events.add(event);
        eventDao eventDao = mock(eventDao.class);

        when(eventDao.findByName(name)).thenReturn(events);

        List<Event> foundEvents = eventDao.findByName(name);

        assertNotNull(foundEvents);
        assertEquals(1, foundEvents.size());
        assertEquals(event, foundEvents.get(0));
    }

    @Test
    public void testDeleteEvent() {
        Long eventId = 1L;
        eventDao eventDao = mock(eventDao.class);

        doNothing().when(eventDao).delete(eventId);

        eventDao.delete(eventId);

        // Verify if delete was called once
        verify(eventDao, times(1)).delete(eventId);
    }

    @Test
    public void testDeleteNonExistentEvent() {
        Long eventId = 999L; // Assuming this event ID does not exist
        eventDao eventDao = mock(eventDao.class);

        doNothing().when(eventDao).delete(eventId);

        // Ensure no exception is thrown
        eventDao.delete(eventId);

        verify(eventDao, times(1)).delete(eventId);
    }
}
