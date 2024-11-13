import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VenueRepository extends JpaRepository<Venue, Long> {

    // Find a venue by its name
    List<Venue> findByName(String name);

    // Find venues by location (address)
    List<Venue> findByAddressContaining(String address);

    // Find venues with a capacity greater than or equal to the specified number
    List<Venue> findByCapacityGreaterThanEqual(int capacity);

    // Find venues that offer specific facilities
    List<Venue> findByFacilitiesContains(String facility);
}
