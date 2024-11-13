import java.util.List;

public interface VenueDao {

    // Save or update a venue
    Venue save(Venue venue);

    // Find a venue by ID
    Venue findById(Long venueId);

    // Find venues by name
    List<Venue> findByName(String name);

    // Find venues by location (address)
    List<Venue> findByAddress(String address);

    // Find venues with a minimum capacity
    List<Venue> findByCapacity(int capacity);

    // Find venues offering a specific facility
    List<Venue> findByFacility(String facility);

    // Delete a venue
    void delete(Long venueId);
}
