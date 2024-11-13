import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    // Add or update a venue
    @PostMapping("/save")
    public Venue saveVenue(@RequestBody Venue venue) {
        return venueService.saveVenue(venue);
    }

    // Get a venue by ID
    @GetMapping("/{venueId}")
    public Venue getVenueById(@PathVariable Long venueId) {
        return venueService.getVenueById(venueId);
    }

    // Find venues by name
    @GetMapping("/searchByName")
    public List<Venue> findVenuesByName(@RequestParam String name) {
        return venueService.findVenuesByName(name);
    }

    // Find venues by address
    @GetMapping("/searchByAddress")
    public List<Venue> findVenuesByAddress(@RequestParam String address) {
        return venueService.findVenuesByAddress(address);
    }

    // Find venues by capacity
    @GetMapping("/searchByCapacity")
    public List<Venue> findVenuesByCapacity(@RequestParam int capacity) {
        return venueService.findVenuesByCapacity(capacity);
    }

    // Find venues by a specific facility
    @GetMapping("/searchByFacility")
    public List<Venue> findVenuesByFacility(@RequestParam String facility) {
        return venueService.findVenuesByFacility(facility);
    }

    // Delete a venue
    @DeleteMapping("/delete/{venueId}")
    public void deleteVenue(@PathVariable Long venueId) {
        venueService.deleteVenue(venueId);
    }
}
``
