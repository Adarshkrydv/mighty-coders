import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

package com.eventmanagement.dao;

import com.eventmanagement.model.Registration;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class RegistrationDAOTest {

    private RegistrationDAO registrationDAO;
    private Registration registration;

    @BeforeEach
    void setUp() {
        registrationDAO = new RegistrationDAO();
        registration = new Registration();
        registration.setUserId(1L); // Assuming the userId is set to 1 for testing
        registration.setEventId(100L); // Assuming the eventId is set to 100 for testing
    }

    @AfterEach
    void tearDown() {
        if (registration != null && registration.getId() != null) {
            registrationDAO.deleteRegistration(registration.getId());
        }
        registrationDAO.close();
    }

    @Test
    void testSaveRegistration() {
        registrationDAO.saveRegistration(registration);
        assertNotNull(registration.getId(), "Registration ID should not be null after saving");
    }

    @Test
    void testFindRegistrationByUserAndEvent() {
        registrationDAO.saveRegistration(registration);

        // Check if registration is found
        Registration foundRegistration = registrationDAO.findRegistrationByUserAndEvent(registration.getUserId(), registration.getEventId());
        assertNotNull(foundRegistration, "Registration should be found by userId and eventId");
        assertEquals(registration.getUserId(), foundRegistration.getUserId(), "User IDs should match");
        assertEquals(registration.getEventId(), foundRegistration.getEventId(), "Event IDs should match");
    }

    @Test
    void testFindRegistrationsByEvent() {
        registrationDAO.saveRegistration(registration);

        // Save another registration with the same eventId
        Registration anotherRegistration = new Registration();
        anotherRegistration.setUserId(2L);
        anotherRegistration.setEventId(100L);
        registrationDAO.saveRegistration(anotherRegistration);

        // Check if both registrations for the event are found
        List<Registration> registrations = registrationDAO.findRegistrationsByEvent(100L);
        assertFalse(registrations.isEmpty(), "There should be registrations found for the event");
        assertEquals(2, registrations.size(), "There should be 2 registrations for this event");
    }

    @Test
    void testFindRegistrationsByUser() {

