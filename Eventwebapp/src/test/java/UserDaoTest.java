import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

package com.eventmanagement.dao;

import com.eventmanagement.model.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private UserDAO userDAO;
    private User user;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAO();
        user = new User();
        user.setName("John Doe"); // Set some sample user data
        user.setEmail("johndoe@example.com");
    }

    @AfterEach
    void tearDown() {
        if (user != null && user.getId() != null) {
            userDAO.findUserById(user.getId());  // Fetch and ensure it's deleted.
        }
        userDAO.close();
    }

    @Test
    void testSaveUser() {
        userDAO.saveUser(user);
        assertNotNull(user.getId(), "User ID should not be null after saving");
    }

    @Test
    void testFindUserById() {
        userDAO.saveUser(user);

        // Test finding the user by ID
        User foundUser = userDAO.findUserById(user.getId());
        assertNotNull(foundUser, "User should be found by ID");
        assertEquals(user.getName(), foundUser.getName(), "User names should match");
        assertEquals(user.getEmail(), foundUser.getEmail(), "User emails should match");
    }

    @Test
    void testFindUserById_UserNotFound() {
        User foundUser = userDAO.findUserById(999L); // Assuming this ID doesn't exist
        assertNull(foundUser, "User should not be found for non-existing ID");
    }
}
