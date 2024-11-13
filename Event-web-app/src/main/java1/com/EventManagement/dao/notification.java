import java.util.List;

public interface notificationdao {

    // Save a new notification
    Notification save(Notification notification);

    // Get all notifications for a user
    List<Notification> findAllByUser(User user);

    // Get unread notifications for a user
    List<Notification> findUnreadByUser(User user);

    // Mark a notification as read
    Notification markAsRead(Long notificationId);

    // Delete a notification
    void delete(Long notificationId);
}
