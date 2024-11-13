import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface repository extends Jparepository<User, Long> {

    // Find a user by username
    Optional<User> findByUsername(String username);

    // Find a user by email
    Optional<User> findByEmail(String email);
}
