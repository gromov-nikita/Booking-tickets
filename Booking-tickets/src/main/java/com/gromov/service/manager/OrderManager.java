package com.gromov.service.manager;

import com.gromov.models.entity.OrderEntity;
import com.gromov.models.entity.UserEntity;
import com.gromov.service.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.boot.jaxb.internal.stax.JpaOrmXmlEventReader;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class OrderManager {
    public static List<OrderEntity> getOrderHistory(int userID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<OrderEntity> history = session.createNamedQuery("getOrdersByUserID")
                .setParameter("userId", userID).getResultList();
        session.close();
        return history;
    }
    public static List<OrderEntity> getOrders() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<OrderEntity> availableOrders = session.createNamedQuery("getAvailableOrders")
                .setParameter("date",new Timestamp(GregorianCalendar.getInstance().getTime().getTime()))
                .getResultList();
        session.close();
        return availableOrders;
    }
    public static int postComment(int orderId, String text) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int answer = session.createNamedQuery("postComment")
                .setParameter("orderId",orderId).setParameter("text",text).executeUpdate();
        session.close();
        return answer;
    }
}
