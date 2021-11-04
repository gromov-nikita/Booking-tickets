package com.gromov.servlet;

import com.gromov.models.entity.UserEntity;
import com.gromov.service.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpHandler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        UserEntity user = new UserEntity();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setPassportId(req.getParameter("passportID"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        int i = UserDAO.signUp(user);
        if(i>0) {
            resp.sendRedirect("http://localhost:8080/Booking_tickets_war_exploded/menuF");
        }
        else {
            resp.sendRedirect("http://localhost:8080/Booking_tickets_war_exploded/signUpPage");
        }
    }
}
