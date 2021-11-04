package com.gromov.servlet;

import com.gromov.models.entity.TripEntity;
import com.gromov.service.hibernate.HibernateUtil;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

public class GetAvailableTrips extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<TripEntity> availableOrders = session.createNamedQuery("getAvailableTrips")
                .setParameter("date",new Timestamp(GregorianCalendar.getInstance().getTime().getTime()))
                .getResultList();
        for(TripEntity t : availableOrders) {
            printWriter.println(t);
        }

    }
}
