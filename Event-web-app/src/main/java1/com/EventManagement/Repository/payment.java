import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find all payments made by a user
    List<Payment> findByUser(User user);

    // Find all payments for a specific event
    List<Payment> findByEvent(Event event);

    // Find a payment by its status
    List<Payment> findByStatus(Payment.PaymentStatus status);

    // Find a payment by user and event
    Optional<Payment> findByUserAndEvent(User user, Event event);
}
