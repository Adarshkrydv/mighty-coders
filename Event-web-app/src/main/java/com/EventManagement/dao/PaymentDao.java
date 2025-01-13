package com.EventManagement.dao;

import java.util.List;
import java.util.Optional;

public interface PaymentDao {

    // Save or update a payment
    PaymentDao save(PaymentDao payment);

    // Find a payment by ID
    PaymentDao findById(Long paymentId);

    // Get all payments for a user
    List<PaymentDao> findByUser(User user);

    // Get all payments for an event
    List<PaymentDao> findByEvent(Event event);

    // Get payments by status
    List<Payment> findByStatus(Payment.PaymentStatus status);

    // Find a specific payment by user and event
    Optional<Payment> findByUserAndEvent(User user, Event event);

    // Delete a payment
    void delete(Long paymentId);
}
