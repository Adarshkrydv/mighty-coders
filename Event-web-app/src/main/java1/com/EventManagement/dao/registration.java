import java.util.List;
import java.util.Optional;

public interface RegistrationDao {

    // Save or update a registration
    Registration save(Registration registration);

    // Find a registration by ID
    Registration findById(Long registrationId);

    // Find all registrations for a specific user
    List<Registration> findByUser(User user);

    // Find all registrations for a specific event
    List<Registration> findByEvent(Event event);

    // Find a registration by user and event
    Optional<Registration> findByUserAndEvent(User user, Event event);

    // Find all confirmed registrations for an event
    List<Registration> findByEventAndConfirmed(Event event, boolean confirmed);

    // Delete a registration
    void delete(Long registrationId);
}
