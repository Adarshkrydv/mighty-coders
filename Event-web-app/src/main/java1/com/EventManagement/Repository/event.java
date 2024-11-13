import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    // Find all events by category
    List<Event> findByEventCategory(EventCategory eventCategory);

    // Find all events occurring on or after a specific date
    List<Event> findByEventDateAfter(java.util.Date date);
    
    // Find events by name (fuzzy search)
    List<Event> findByNameContaining(String name);
}
