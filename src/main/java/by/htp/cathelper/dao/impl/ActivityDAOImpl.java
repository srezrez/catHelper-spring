package by.htp.cathelper.dao.impl;

import by.htp.cathelper.dao.ActivityDAO;
import by.htp.cathelper.entity.Activity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityDAOImpl implements ActivityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Activity> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Activity> theQuery =
                currentSession.createQuery("from Activity",
                        Activity.class);
        List<Activity> activities = theQuery.getResultList();
        return activities;
    }
}
