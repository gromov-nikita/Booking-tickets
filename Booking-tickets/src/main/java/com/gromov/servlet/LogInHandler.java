package com.gromov.servlet;

import com.gromov.models.entity.UserEntity;
import com.gromov.service.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LogInHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        UserEntity user = UserDAO.logIn(req.getParameter("email"),req.getParameter("password"));
        if(user != null) {
            resp.sendRedirect("http://localhost:8080/Booking_tickets_war_exploded/menuF");
        }
        else {
            resp.sendRedirect("http://localhost:8080/Booking_tickets_war_exploded/signUpPage");
        }
    }
}
