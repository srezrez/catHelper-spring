package by.htp.cathelper.service.impl;

import by.htp.cathelper.dao.CatDAO;
import by.htp.cathelper.dao.RequestDAO;
import by.htp.cathelper.dao.StatusDAO;
import by.htp.cathelper.dao.UserDAO;
import by.htp.cathelper.entity.Cat;
import by.htp.cathelper.entity.Request;
import by.htp.cathelper.entity.Status;
import by.htp.cathelper.entity.User;
import by.htp.cathelper.service.RequestService;
import by.htp.cathelper.viewmodel.RequestViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDAO requestDAO;
    @Autowired
    private CatDAO catDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private StatusDAO statusDAO;

    @Transactional
    @Override
    public List<Request> getAllUserRequests(int requesterId, int statusId) {
        return requestDAO.getAllUserRequests(requesterId, statusId);
    }

    @Transactional
    @Override
    public void saveRequest(int catId, int requesterId) {
        User requester = userDAO.getUser(requesterId);
        Cat cat = catDAO.getCat(catId);
        Status status = statusDAO.getStatus(1);
        Date requestDate = new Date();
        Request request = new Request();
        request.setDateRequest(requestDate);
        request.setRequester(requester);
        request.setCat(cat);
        request.setStatus(status);
        requestDAO.saveRequest(request);
    }

    @Transactional
    @Override
    public RequestViewModel getCurrentRequest(int catId) {
        List<Request> requests = requestDAO.getActiveRequests(catId);
        RequestViewModel requestViewModel = new RequestViewModel();
        requestViewModel.setActiveRequestAmount(requests.size());
        requestViewModel.setId(requests.get(0).getId());
        requestViewModel.setRequester(requests.get(0).getRequester());
        return requestViewModel;
    }

    @Transactional
    @Override
    public void setRequestDecision(int requestId, String decision) {
        Request request = requestDAO.getRequest(requestId);
        Status status = statusDAO.getStatus(decision);
        request.setStatus(status);
        Date issueDate = new Date();
        request.setDateIssue(issueDate);
        requestDAO.saveRequest(request);
    }
}
