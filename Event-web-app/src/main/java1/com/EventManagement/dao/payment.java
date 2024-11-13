import java.util.List;
import java.util.Optional;

public interface PaymentDao {

    // Save or update a payment
    Payment save(Payment payment);

    // Find a payment by ID
    Payment findById(Long paymentId);

    // Get all payments for a user
    List<Payment> findByUser(User user);

    // Get all payments for an event
    List<Payment> findByEvent(Event event);

    // Get payments by status
    List<Payment> findByStatus(Payment.PaymentStatus status);

    // Find a specific payment by user and event
    Optional<Payment> findByUserAndEvent(User user, Event event);

    // Delete a payment
    void delete(Long paymentId);
}
