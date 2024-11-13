import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserAndStatusOrderByCreatedAtDesc(User user, Notification.NotificationStatus status);
    
    List<Notification> findByUserOrderByCreatedAtDesc(User user);
}
