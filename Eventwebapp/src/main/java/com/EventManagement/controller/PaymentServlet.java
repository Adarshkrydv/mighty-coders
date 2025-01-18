package com.eventmanagement.servlet;

import com.eventmanagement.dao.PaymentDAO;
import com.eventmanagement.dao.UserDAO;
import com.eventmanagement.dao.EventDAO;
import com.eventmanagement.model.Payment;
import com.eventmanagement.model.User;
import com.eventmanagement.model.Event;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/processPayment")
public class PaymentServlet extends HttpServlet {
    private PaymentDAO paymentDAO;
    private UserDAO userDAO;
    private EventDAO eventDAO;

    public void init() {
        paymentDAO = new PaymentDAO();
        userDAO = new UserDAO();
        eventDAO = new EventDAO();
    }

    // Process payment for a user attending an event
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("userId"));
        Long eventId = Long.parseLong(request.getParameter("eventId"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        // Fetch the user and event details from the database
        User user = userDAO.findUserById(userId);
        Event event = eventDAO.findEventById(eventId);

        if (user != null && event != null) {
            // Create a new Payment record
            Payment payment = new Payment();
            payment.setUserId(user.getId());
            payment.setEventId(event.getId());
            payment.setAmount(amount);

            // Save the payment to the database
            paymentDAO.savePayment(payment);

            // Redirect to a confirmation page after payment is processed
            response.sendRedirect("paymentConfirmation.jsp");
        } else {
            // If the user or event is not found, show an error
            request.setAttribute("errorMessage", "User or Event not found.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    // Close resources when servlet is destroyed
    public void destroy() {
        paymentDAO.close();
    }
}
