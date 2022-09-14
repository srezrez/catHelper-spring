package by.htp.cathelper.dao.impl;

import by.htp.cathelper.dao.StatusDAO;
import by.htp.cathelper.entity.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatusDAOImpl implements StatusDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Status getStatus(int statusId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Status status = currentSession.get(Status.class, statusId);
        return status;
    }

    @Override
    public Status getStatus(String key) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Status> query =
                currentSession.createQuery("SELECT st FROM Status st WHERE st.key = :key")
                        .setParameter("key", key);
        Status status = query.getSingleResult();
        return status;
    }
}
