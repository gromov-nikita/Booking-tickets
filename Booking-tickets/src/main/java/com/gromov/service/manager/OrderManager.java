package com.gromov.service.manager;

import com.gromov.models.entity.OrderEntity;
import com.gromov.models.entity.UserEntity;
import com.gromov.service.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.boot.jaxb.internal.stax.JpaOrmXmlEventReader;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class OrderManager {
    private UserEntity user;
    public OrderManager(UserEntity user) {
        this.user = user;
    }
    public UserEntity getUser() {
        return user;
    }
    public List<OrderEntity> getOrderHistory() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<OrderEntity> history =
    }
}
