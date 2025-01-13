import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import java.util.Optional;

public class UserDaoTest {

    @Test
    public void testSaveUser() {
        User user = new User("JohnDoe", "john.doe@example.com");
        UserDao<User> userDao = mock(UserDao.class);

        when(userDao.save(user)).thenReturn(user);

        User savedUser = userDao.save(user);

        assertNotNull(savedUser);
        assertEquals("JohnDoe", savedUser.getUsername());
        assertEquals("john.doe@example.com", savedUser.getEmail());
    }

    @Test
    public void testFindById() {
        Long userId = 1L;
        User user = new User("JohnDoe", "john.doe@example.com");
        UserDao<User> userDao = mock(UserDao.class);

        when(userDao.findById(userId)).thenReturn(user);

        User foundUser = userDao.findById(userId);

        assertNotNull(foundUser);
        assertEquals(userId, foundUser.getId());
        assertEquals("JohnDoe", foundUser.getUsername());
    }

    @Test
    public void testFindByUsername_Exists() {
        String username = "JohnDoe";
        User user = new User(username, "john.doe@example.com");
        UserDao<User> userDao = mock(UserDao.class);

        when(userDao.findByUsername(username)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userDao.findByUsername(username);

        assertTrue(foundUser.isPresent());
        assertEquals("JohnDoe", foundUser.get().getUsername());
    }

    @Test
    public void testFindByUsername_NotFound() {
        String username = "NonExistentUser";
        UserDao<User> userDao = mock(UserDao.class);

        when(userDao.findByUsername(username)).thenReturn(Optional.empty());

        Optional<User> foundUser = userDao.findByUsername(username);

        assertFalse(foundUser.isPresent());
    }

    @Test
    public void testFindByEmail_Exists() {
        String email = "john.doe@example.com";
        User user = new User("JohnDoe", email);
        UserDao<User> userDao = mock(UserDao.class);

        when(userDao.findByEmail(email)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userDao.findByEmail(email);

        assertTrue(foundUser.isPresent());
        assertEquals(email, foundUser.get().getEmail());
    }

    @Test
    public void testFindByEmail_NotFound() {
        String email = "nonexistent@example.com";
        UserDao<User> userDao = mock(UserDao.class);

        when(userDao.findByEmail(email)).thenReturn(Optional.empty());

        Optional<User> foundUser = userDao.findByEmail(email);

        assertFalse(foundUser.isPresent());
    }

    @Test
    public void testDeleteUser() {
        Long userId = 1L;
        UserDao<User> userDao = mock(UserDao.class);

        doNothing().when(userDao).delete(userId);

        userDao.delete(userId);

        // Verify if delete was called
        verify(userDao, times(1)).delete(userId);
    }

    @Test
    public void testSaveNullUser() {
        UserDao<User> userDao = mock(UserDao.class);

        assertThrows(IllegalArgumentException.class, () -> {
            userDao.save(null);
        });
    }

    @Test
    public void testFindById_NotFound() {
        Long userId = 999L; // Assuming this ID doesn't exist
        UserDao<User> userDao = mock(UserDao.class);

        when(userDao.findById(userId)).thenReturn(null);

        User foundUser = userDao.findById(userId);

        assertNull(foundUser);
    }

    @Test
    public void testDeleteNonExistentUser() {
        Long userId = 999L; // Assuming this ID doesn't exist
        UserDao<User> userDao = mock(UserDao.class);

        doNothing().when(userDao).delete(userId);

        // Ensure no exception is thrown
        userDao.delete(userId);

        // Verify if delete was called
        verify(userDao, times(1)).delete(userId);
    }

}
