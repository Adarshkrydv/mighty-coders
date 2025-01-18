package com.eventmanagement.servlet;

import com.eventmanagement.model.Event;
import com.eventmanagement.dao.EventDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/eventServlet")
public class EventServlet extends HttpServlet {
    private EventDAO eventDAO;

    public void init() {
        eventDAO = new EventDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventName = request.getParameter("name");
        String eventDescription = request.getParameter("description");
        String eventDate = request.getParameter("date");

        Event event = new Event();
        event.setName(eventName);
        event.setDescription(eventDescription);
        event.setDate(eventDate);

        eventDAO.saveEvent(event);
        response.sendRedirect("eventList.jsp");
    }

    public void destroy() {
        eventDAO.close();
    }
}
