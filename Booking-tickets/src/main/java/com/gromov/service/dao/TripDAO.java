package com.gromov.service.dao;

import com.gromov.models.entity.TripEntity;
import com.gromov.service.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

public class TripDAO {
    public List<TripEntity> getAvailableTrips() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from TripEntity as o where o.date >="
                + "'" + new Timestamp(GregorianCalendar.getInstance().getTime().getTime()) + "'")
                .list();
    }
}
