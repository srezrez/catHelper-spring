package by.htp.cathelper.service.impl;

import by.htp.cathelper.dao.RequestDAO;
import by.htp.cathelper.entity.Request;
import by.htp.cathelper.entity.Status;
import by.htp.cathelper.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDAO requestDAO;

    @Transactional
    @Override
    public List<Request> getAllUserRequests(int requesterId, int statusId) {
        return requestDAO.getAllUserRequests(requesterId, statusId);
    }
}
