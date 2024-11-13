import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    // Find all registrations for a specific user
    List<Registration> findByUser(User user);

    // Find all registrations for a specific event
    List<Registration> findByEvent(Event event);

    // Find a registration by user and event
    Optional<Registration> findByUserAndEvent(User user, Event event);
    
    // Find all confirmed registrations for an event
    List<Registration> findByEventAndConfirmed(Event event, boolean confirmed);
}
