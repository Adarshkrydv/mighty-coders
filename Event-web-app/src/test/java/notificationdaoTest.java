import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import java.util.*;

public class NotificationDaoTest {

    @Test
    public void testSaveNotification() {
        Notification notification = mock(Notification.class);
        notificationdao notificationDao = mock(notificationdao.class);

        when(notificationDao.save(notification)).thenReturn(notification);

        Notification savedNotification = notificationDao.save(notification);

        assertNotNull(savedNotification);
        verify(notificationDao, times(1)).save(notification);
    }

    @Test
    public void testFindAllByUser() {
        User testUser = mock(User.class);
        List<Notification> notifications = new ArrayList<>();
        Notification notification = mock(Notification.class);
        notifications.add(notification);
        notificationdao notificationDao = mock(notificationdao.class);

        when(notificationDao.findAllByUser(testUser)).thenReturn(notifications);

        List<Notification> foundNotifications = notificationDao.findAllByUser(testUser);

        assertNotNull(foundNotifications);
        assertEquals(1, foundNotifications.size());
        assertEquals(notification, foundNotifications.get(0));
    }

    @Test
    public void testFindUnreadByUser() {
        User testUser = mock(User.class);
        List<Notification> notifications = new ArrayList<>();
        Notification notification = mock(Notification.class);
        notifications.add(notification);
        notificationdao notificationDao = mock(notificationdao.class);

        when(notificationDao.findUnreadByUser(testUser)).thenReturn(notifications);

        List<Notification> unreadNotifications = notificationDao.findUnreadByUser(testUser);

        assertNotNull(unreadNotifications);
        assertEquals(1, unreadNotifications.size());
        assertEquals(notification, unreadNotifications.get(0));
    }

    @Test
    public void testMarkAsRead() {
        Long notificationId = 1L;
        Notification notification = mock(Notification.class);
        notificationdao notificationDao = mock(notificationdao.class);

        when(notificationDao.markAsRead(notificationId)).thenReturn(notification);

        Notification markedNotification = notificationDao.markAsRead(notificationId);

        assertNotNull(markedNotification);
        verify(notificationDao, times(1)).markAsRead(notificationId);
    }

    @Test
    public void testDeleteNotification() {
        Long notificationId = 1L;
        notificationdao notificationDao = mock(notificationdao.class);

        doNothing().when(notificationDao).delete(notificationId);

        notificationDao.delete(notificationId);

        verify(notificationDao, times(1)).delete(notificationId);
    }

    @Test
    public void testDeleteNonExistentNotification() {
        Long notificationId = 999L; // Assuming this notification ID does not exist
        notificationdao notificationDao = mock(notificationdao.class);

        doNothing().when(notificationDao).delete(notificationId);

        // Ensure no exception is thrown
        notificationDao.delete(notificationId);

        verify(notificationDao, times(1)).delete(notificationId);
    }
}

