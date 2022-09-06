package by.htp.cathelper.dao.impl;

import by.htp.cathelper.dao.CatDAO;
import by.htp.cathelper.entity.Activity;
import by.htp.cathelper.entity.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static by.htp.cathelper.util.ConstantPool.STATUS_ACCEPTED;

import java.util.List;

@Repository
public class CatDAOImpl implements CatDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Cat> getAllFreeCats() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Cat> theQuery =
                currentSession.createQuery("SELECT cat FROM Cat cat LEFT JOIN cat.requests req LEFT JOIN req.status st where SIZE(cat.requests) = 0 OR st.key != :acceptedKey")
                        .setParameter("acceptedKey", STATUS_ACCEPTED);
        List<Cat> cats = theQuery.getResultList();
        return cats;
    }

    @Override
    public List<Cat> getAddedCats(int ownerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Cat> theQuery =
                currentSession.createQuery("SELECT cat FROM Cat cat JOIN cat.owner own WHERE own.id = :ownerId")
                        .setParameter("ownerId", ownerId);
        List<Cat> cats = theQuery.getResultList();
        return cats;
    }
}
