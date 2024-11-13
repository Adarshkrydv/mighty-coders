import java.util.Optional;

public interface UserDao {

    // Save or update a user
    User save(User user);

    // Find a user by their ID
    User findById(Long userId);

    // Find a user by their username
    Optional<User> findByUsername(String username);

    // Find a user by their email
    Optional<User> findByEmail(String email);

    // Delete a user
    void delete(Long userId);
}
