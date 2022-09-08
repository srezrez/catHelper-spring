package by.htp.cathelper.dao.impl;

import by.htp.cathelper.dao.RequestDAO;
import by.htp.cathelper.entity.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static by.htp.cathelper.util.ConstantPool.STATUS_CREATED;

@Repository
public class RequestDAOImpl implements RequestDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Request> getAllUserRequests(int requesterId, int statusId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Request> theQuery =
                currentSession.createQuery("SELECT request FROM Request request JOIN request.requester req JOIN request.status st WHERE req.id = :param AND st.id = :stat")
                        .setParameter("param", requesterId)
                        .setParameter("stat", statusId);
        List<Request> requests = theQuery.getResultList();
        return requests;
    }

    @Override
    public void saveRequest(Request request) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(request);
    }

    @Override
    public List<Request> getActiveRequests(int catId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Request> query =
                currentSession.createQuery("SELECT req FROM Request req JOIN req.cat cat JOIN req.status st WHERE cat.id = :catid AND st.key = :stkey ORDER BY date(req.dateRequest) DESC")
                        .setParameter("catid", catId)
                        .setParameter("stkey", STATUS_CREATED);
        List<Request> requests = query.getResultList();
        return requests;
    }
}
