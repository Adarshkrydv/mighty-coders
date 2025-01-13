import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import com.EventManagement.model.user;
import org.w3c.dom.events.Event;
import jakarta.servlet.Registration;

public class RegistrationDaoTest {

    @Test
    public void testSaveRegistration() {
        // Create a mock registration object
        Registration registration = mock(Registration.class);
        RegistrationDao registrationDao = mock(RegistrationDao.class);

        when(registrationDao.save(registration)).thenReturn(registration);

        Registration savedRegistration = registrationDao.save(registration);

        assertNotNull(savedRegistration);
        verify(registrationDao, times(1)).save(registration);
    }

    @Test
    public void testFindById() {
        Long registrationId = 1L;
        Registration registration = mock(Registration.class);
        RegistrationDao registrationDao = mock(RegistrationDao.class);

        when(registrationDao.findById(registrationId)).thenReturn(registration);

        Registration foundRegistration = registrationDao.findById(registrationId);

        assertNotNull(foundRegistration);
        assertEquals(registration, foundRegistration);
    }

    @Test
    public void testFindByUser() {
        user testUser = new user("john.doe", "john.doe@example.com");
        List<Registration> registrations = new ArrayList<>();
        Registration registration = mock(Registration.class);
        registrations.add(registration);
        RegistrationDao registrationDao = mock(RegistrationDao.class);

        when(registrationDao.findByUser(testUser)).thenReturn(registrations);

        List<Registration> foundRegistrations = registrationDao.findByUser(testUser);

        assertNotNull(foundRegistrations);
        assertEquals(1, foundRegistrations.size());
        assertEquals(registration, foundRegistrations.get(0));
    }

    @Test
    public void testFindByEvent() {
        Event testEvent = mock(Event.class);
        List<Registration> registrations = new ArrayList<>();
        Registration registration = mock(Registration.class);
        registrations.add(registration);
        RegistrationDao registrationDao = mock(RegistrationDao.class);

        when(registrationDao.findByEvent(testEvent)).thenReturn(registrations);

        List<Registration> foundRegistrations = registrationDao.findByEvent(testEvent);

        assertNotNull(foundRegistrations);
        assertEquals(1, foundRegistrations.size());
        assertEquals(registration, foundRegistrations.get(0));
    }

    @Test
    public void testFindByUserAndEvent() {
        user testUser = new user("john.doe", "john.doe@example.com");
        Event testEvent = mock(Event.class);
        Registration registration = mock(Registration.class);
        RegistrationDao registrationDao = mock(RegistrationDao.class);

        when(registrationDao.findByUserAndEvent(testUser, testEvent)).thenReturn(Optional.of(registration));

        Optional<Registration> foundRegistration = registrationDao.findByUserAndEvent(testUser, testEvent);

        assertTrue(foundRegistration.isPresent());
        assertEquals(registration, foundRegistration.get());
    }

    @Test
    public void testFindByUserAndEvent_NotFound() {
        user testUser = new user("john.doe", "john.doe@example.com");
        Event testEvent = mock(Event.class);
        RegistrationDao registrationDao = mock(RegistrationDao.class);

        when(registrationDao.findByUserAndEvent(testUser, testEvent)).thenReturn(Optional.empty());

        Optional<Registration> foundRegistration = registrationDao.findByUserAndEvent(testUser, testEvent);

        assertFalse(foundRegistration.isPresent());
    }

    @Test
    public void testFindByEventAndConfirmed() {
        Event testEvent = mock(Event.class);
        boolean confirmed = true;
        List<Registration> registrations = new ArrayList<>();
        Registration registration = mock(Registration.class);
        registrations.add(registration);
        RegistrationDao registrationDao = mock(RegistrationDao.class);

        when(registrationDao.findByEventAndConfirmed(testEvent, confirmed)).thenReturn(registrations);

        List<Registration> foundRegistrations = registrationDao.findByEventAndConfirmed(testEvent, confirmed);

        assertNotNull(foundRegistrations);
        assertEquals(1, foundRegistrations.size());
        assertEquals(registration, foundRegistrations.get(0));
    }

    @Test
    public void testDeleteRegistration() {
        Long registrationId = 1L;
        RegistrationDao registrationDao = mock(RegistrationDao.class);

        doNothing().when(registrationDao).delete(registrationId);

        registrationDao.delete(registrationId);

        verify(registrationDao, times(1)).delete(registrationId);
    }

    @Test
    public void testDeleteNonExistentRegistration() {
        Long registrationId = 999L; // Assuming this registration does not exist
        RegistrationDao registrationDao = mock(RegistrationDao.class);

        doNothing().when(registrationDao).delete(registrationId);

        // Ensure no exception is thrown
        registrationDao.delete(registrationId);

        verify(registrationDao, times(1)).delete(registrationId);
    }
}
