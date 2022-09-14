package by.htp.cathelper.service;

import by.htp.cathelper.entity.Request;
import by.htp.cathelper.entity.Status;
import by.htp.cathelper.viewmodel.RequestViewModel;

import java.util.List;

public interface RequestService {

    List<Request> getAllUserRequests(int requesterId, int statusId);
    void saveRequest(int catId, int requesterId);
    RequestViewModel getCurrentRequest(int catId);
    void setRequestDecision(int requestId, String decision);
}
