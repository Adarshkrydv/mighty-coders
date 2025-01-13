package com.EventManagement.dao;

import java.util.List;
import java.util.Optional;

import org.w3c.dom.events.Event;

import com.EventManagement.model.user;

import jakarta.servlet.Registration;

public interface RegistrationDao {

    // Save or update a registration
    Registration save(Registration registration);

    // Find a registration by ID
    Registration findById(Long registrationId);

    // Find all registrations for a specific user
    List<Registration> findByUser(user user);

    // Find all registrations for a specific event
    List<Registration> findByEvent(Event event);

    // Find a registration by user and event
    Optional<Registration> findByUserAndEvent(user user, Event event);

    // Find all confirmed registrations for an event
    List<Registration> findByEventAndConfirmed(Event event, boolean confirmed);

    // Delete a registration
    void delete(Long registrationId);
}
