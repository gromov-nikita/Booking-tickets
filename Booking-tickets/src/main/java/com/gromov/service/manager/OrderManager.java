package com.gromov.service.manager;

import com.gromov.models.entity.OrderEntity;
import com.gromov.models.entity.TripEntity;
import com.gromov.models.enums.Status;
import com.gromov.service.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

public class OrderManager {
    public static List<OrderEntity> getOrderHistory(int userID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<OrderEntity> history = session.createNamedQuery("getOrdersByUserID")
                .setParameter("userId", userID).getResultList();
        session.close();
        return history;
    }
    public static List<TripEntity> getTrips() {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        return session.createNamedQuery("getAvailableTrips")
                .setParameter("date",new Timestamp(GregorianCalendar.getInstance().getTime().getTime()))
                .list();
    }
    public static List<OrderEntity> getOrderById(int orderId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<OrderEntity> order = session.createNamedQuery("getOrderById")
                .setParameter("orderId", orderId).getResultList();
        session.close();
        return order;
    }

    public static int postComment(int orderId, String text) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int answer = session.createNamedQuery("postComment")
                .setParameter("orderId",orderId).setParameter("text",text).executeUpdate();
        session.close();
        return answer;
    }
    public static int changeStatus(int orderId, Status status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int answer = session.createNamedQuery("changeStatus")
                .setParameter("orderId", orderId).setParameter("status", status.getName()).executeUpdate();
        session.close();
        return answer;
    }


}
