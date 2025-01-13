import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Register a user for an event
    @PostMapping("/register")
    public Registration registerForEvent(@RequestParam Long userId,
                                         @RequestParam Long eventId) {
        User user = new User();  // Fetch the user by userId from the DB
        Event event = new Event();  // Fetch the event by eventId from the DB

        return registrationService.registerUserForEvent(user, event);
    }

    // Get all registrations for a user
    @Get
