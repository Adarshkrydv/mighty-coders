package com.eventmanagement.dao;

import com.eventmanagement.model.Event;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EventDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public EventDAO() {
        emf = Persistence.createEntityManagerFactory("EventManagementPU");
        em = emf.createEntityManager();
    }

    public void saveEvent(Event event) {
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
    }

    public Event findEventById(Long id) {
        return em.find(Event.class, id);
    }

    public void close() {
        em.close();
        emf.close();
    }
}
