package by.htp.cathelper.dao.impl;

import by.htp.cathelper.dao.UserDAO;
import by.htp.cathelper.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(int userId) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, userId);
        return user;
    }
}
