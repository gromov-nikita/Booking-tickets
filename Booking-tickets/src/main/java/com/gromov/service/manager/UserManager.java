package com.gromov.service.manager;
import com.gromov.models.entity.UserEntity;
import com.gromov.service.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserManager {
    public static List<UserEntity> logIn(String email, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<UserEntity> users = session.createNamedQuery("logIn").setParameter("email", email)
                .setParameter("password", password).getResultList();
        session.close();
        return users;
    }
    public static int signUp(String firstName, String lastName, String passportID,
                                    String email, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int answer = session.createNamedQuery("signUp").setParameter("firstname", firstName)
                .setParameter("lastName",lastName).setParameter("passportID",passportID)
                .setParameter("email",email).setParameter("password",password).executeUpdate();
        session.close();
        return answer;
    }
}
