package com.gromov.service.dao;

import com.gromov.models.entity.UserEntity;
import com.gromov.service.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {
    public static UserEntity logIn(String email, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        UserEntity user = (UserEntity) session.createQuery(
                "from UserEntity as u where u.email = :email AND u.password = :password")
                    .setParameter("email",email).setParameter("password",password)
                        .getSingleResult();
        session.close();
        return user;
    }
    public static int signUp(UserEntity user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        int i = (Integer) session.save(user);
        transaction.commit();
        session.close();
        return i;
    }
}
