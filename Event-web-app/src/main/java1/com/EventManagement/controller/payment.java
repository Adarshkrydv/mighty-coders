import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Process a new payment
    @PostMapping("/process")
    public Payment processPayment(@RequestParam Long userId,
                                  @RequestParam Long eventId,
                                  @RequestParam double amount,
                                  @RequestParam String paymentMethod) {
        User user = new User();  // Ideally, you fetch the user from DB
