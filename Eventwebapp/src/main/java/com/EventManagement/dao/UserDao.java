package com.eventmanagement.dao;

import com.eventmanagement.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public UserDAO() {
        emf = Persistence.createEntityManagerFactory("EventManagementPU");
        em = emf.createEntityManager();
    }

    public void saveUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public User findUserById(Long id) {
        return em.find(User.class, id);
    }

    public void close() {
        em.close();
        emf.close();
    }
}
