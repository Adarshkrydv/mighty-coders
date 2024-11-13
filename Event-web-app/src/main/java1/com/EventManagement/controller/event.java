import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Create or update an event
    @PostMapping("/create")
    public Event createOrUpdateEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    // Get an event by ID
    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId);
    }

    // Get events by category
    @GetMapping("/category/{categoryId}")
    public List<Event> getEventsByCategory(@PathVariable Long categoryId) {
        EventCategory category = new EventCategory();
        category.setCategoryId(categoryId);
        return eventService.getEventsByCategory(category);
    }

    // Get upcoming events after a specific date
    @GetMapping("/upcoming")
    public List<Event> getUpcomingEvents(@RequestParam java.util.Date date) {
        return eventService.getUpcomingEvents(date);
    }

    // Search events by name
    @GetMapping("/search")
    public List<Event> searchEventsByName(@RequestParam String name) {
        return eventService.searchEventsByName(name);
    }

    // Delete an event
    @DeleteMapping("/delete/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
    }
}
