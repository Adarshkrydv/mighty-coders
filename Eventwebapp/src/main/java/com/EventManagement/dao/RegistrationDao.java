package com.eventmanagement.dao;

import com.eventmanagement.model.Registration;
import javax.persistence.*;

public class RegistrationDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public RegistrationDAO() {
        emf = Persistence.createEntityManagerFactory("EventManagementPU");
        em = emf.createEntityManager();
    }

    // Save a new registration
    public void saveRegistration(Registration registration) {
        em.getTransaction().begin();
        em.persist(registration);  // Persist the registration to the database
        em.getTransaction().commit();
    }

    // Find a registration by userId and eventId (to check if a user is already registered for an event)
    public Registration findRegistrationByUserAndEvent(Long userId, Long eventId) {
        try {
            String query = "SELECT r FROM Registration r WHERE r.userId = :userId AND r.eventId = :eventId";
            return em.createQuery(query, Registration.class)
                     .setParameter("userId", userId)
                     .setParameter("eventId", eventId)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;  // No registration found
        }
    }

    // Find all registrations for a specific event
    public List<Registration> findRegistrationsByEvent(Long eventId) {
        String query = "SELECT r FROM Registration r WHERE r.eventId = :eventId";
        return em.createQuery(query, Registration.class)
                 .setParameter("eventId", eventId)
                 .getResultList();
    }

    // Find all registrations by userId
    public List<Registration> findRegistrationsByUser(Long userId) {
        String query = "SELECT r FROM Registration r WHERE r.userId = :userId";
        return em.createQuery(query, Registration.class)
                 .setParameter("userId", userId)
                 .getResultList();
    }

    // Delete a registration by its ID
    public void deleteRegistration(Long registrationId) {
        Registration registration = em.find(Registration.class, registrationId);
        if (registration != null) {
            em.getTransaction().begin();
            em.remove(registration);  // Remove the registration from the database
            em.getTransaction().commit();
        }
    }

    // Close the EntityManager and EntityManagerFactory
    public void close() {
        em.close();
        emf.close();
    }
}
