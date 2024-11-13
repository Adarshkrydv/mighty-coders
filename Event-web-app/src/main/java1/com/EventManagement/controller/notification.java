import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class notificationcontroller {

    @Autowired
    private NotificationService notificationService;

    // Create a new notification
    public Notification createNotification(@RequestParam Long userId,
                                           @RequestParam String title,
                                           @RequestParam String message) {
        // Assume userService or similar service to fetch User by ID
        User user = userService.getUserById(userId);
        return notificationService.createNotification(user, title, message);
    }

    // Get all notifications for a user
    @GetMapping("/all")
    public List<Notification> getAllNotifications(@RequestParam Long userId) {
        User user = userService.getUserById(userId);
        return notificationService.getAllNotificationsForUser(user);
    }

    // Get unread notifications for a user
    @GetMapping("/unread")
    public List<Notification> getUnreadNotifications(@RequestParam Long userId) {
        User user = userService.getUserById(userId);
        return notificationService.getUnreadNotificationsForUser(user);
    }

    // Mark a notification as read
    @PostMapping("/markAsRead")
    public Notification markAsRead(@RequestParam Long notificationId) {
        return notificationService.markAsRead(notificationId);
    }

    // Delete a notification
    @DeleteMapping("/delete/{notificationId}")
    public void deleteNotification(@PathVariable Long notificationId) {
        notificationService.deleteNotification(notificationId);
    }
}
