package com.eventmanagement.servlet;

import com.eventmanagement.dao.UserDAO;
import com.eventmanagement.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    // Handle user registration
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create a new user and save it in the database
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        userDAO.saveUser(user);

        // Redirect to the login page after successful registration
        response.sendRedirect("login.jsp");
    }

    // Handle user login
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Find the user based on username and password
        User user = userDAO.findUserByUsernameAndPassword(username, password);

        if (user != null) {
            // Successful login
            request.setAttribute("user", user);
            request.getRequestDispatcher("/userDashboard.jsp").forward(request, response);
        } else {
            // Invalid credentials
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    // Close resources when servlet is destroyed
    public void destroy() {
        userDAO.close();
    }
}
