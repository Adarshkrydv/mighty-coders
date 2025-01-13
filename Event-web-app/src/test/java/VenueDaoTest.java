import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import java.util.*;

public class VenueDaoTest {

    @Test
    public void testSaveVenue() {
        VenueDao venue = mock(VenueDao.class);
        VenueDao venueDao = mock(VenueDao.class);

        when(venueDao.save(venue)).thenReturn(venue);

        VenueDao savedVenue = venueDao.save(venue);

        assertNotNull(savedVenue);
        verify(venueDao, times(1)).save(venue);
    }

    @Test
    public void testFindById() {
        Long venueId = 1L;
        VenueDao venue = mock(VenueDao.class);
        VenueDao venueDao = mock(VenueDao.class);

        when(venueDao.findById(venueId)).thenReturn(venue);

        VenueDao foundVenue = venueDao.findById(venueId);

        assertNotNull(foundVenue);
        assertEquals(venue, foundVenue);
    }

    @Test
    public void testFindByName() {
        String name = "Convention Center";
        List<VenueDao> venues = new ArrayList<>();
        VenueDao venue = mock(VenueDao.class);
        venues.add(venue);
        VenueDao venueDao = mock(VenueDao.class);

        when(venueDao.findByName(name)).thenReturn(venues);

        List<VenueDao> foundVenues = venueDao.findByName(name);

        assertNotNull(foundVenues);
        assertEquals(1, foundVenues.size());
        assertEquals(venue, foundVenues.get(0));
    }

    @Test
    public void testFindByAddress() {
        String address = "123 Main St, Cityville";
        List<VenueDao> venues = new ArrayList<>();
        VenueDao venue = mock(VenueDao.class);
        venues.add(venue);
        VenueDao venueDao = mock(VenueDao.class);

        when(venueDao.findByAddress(address)).thenReturn(venues);

        List<VenueDao> foundVenues = venueDao.findByAddress(address);

        assertNotNull(foundVenues);
        assertEquals(1, foundVenues.size());
        assertEquals(venue, foundVenues.get(0));
    }

    @Test
    public void testFindByCapacity() {
        int capacity = 500;
        List<VenueDao> venues = new ArrayList<>();
        VenueDao venue = mock(VenueDao.class);
        venues.add(venue);
        VenueDao venueDao = mock(VenueDao.class);

        when(venueDao.findByCapacity(capacity)).thenReturn(venues);

        List<VenueDao> foundVenues = venueDao.findByCapacity(capacity);

        assertNotNull(foundVenues);
        assertEquals(1, foundVenues.size());
        assertEquals(venue, foundVenues.get(0));
    }

    @Test
    public void testFindByFacility() {
        String facility = "Wi-Fi";
        List<VenueDao> venues = new ArrayList<>();
        VenueDao venue = mock(VenueDao.class);
        venues.add(venue);
        VenueDao venueDao = mock(VenueDao.class);

        when(venueDao.findByFacility(facility)).thenReturn(venues);

        List<VenueDao> foundVenues = venueDao.findByFacility(facility);

        assertNotNull(foundVenues);
        assertEquals(1, foundVenues.size());
        assertEquals(venue, foundVenues.get(0));
    }

    @Test
    public void testDeleteVenue() {
        Long venueId = 1L;
        VenueDao venueDao = mock(VenueDao.class);

        doNothing().when(venueDao).delete(venueId);

        venueDao.delete(venueId);

        // Verify if delete was called once
        verify(venueDao, times(1)).delete(venueId);
    }

    @Test
    public void testDeleteNonExistentVenue() {
        Long venueId = 999L; // Assuming this venue ID does not exist
        VenueDao venueDao = mock(VenueDao.class);

        doNothing().when(venueDao).delete(venueId);

        // Ensure no exception is thrown
        venueDao.delete(venueId);

        // Verify if delete was called once
        verify(venueDao, times(1)).delete(venueId);
    }
}
