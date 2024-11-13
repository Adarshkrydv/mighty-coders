import java.util.List;

public interface eventDao {

    // Save a new or update an existing event
    Event save(Event event);

    // Get an event by its ID
    Event findById(Long eventId);

    // Get all events by category
    List<Event> findByCategory(EventCategory eventCategory);

    // Get all events happening after a specific date
    List<Event> findUpcomingEvents(java.util.Date date);

    // Find events by name (partial search)
    List<Event> findByName(String name);

    // Delete an event
    void delete(Long eventId);
}
