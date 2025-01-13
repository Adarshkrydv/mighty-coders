package com.EventManagement.model;

import java.util.List;

import javax.management.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserAndStatusOrderByCreatedAtDesc(user user, Notification status);
    
    List<Notification> findByUserOrderByCreatedAtDesc(user user);
}
