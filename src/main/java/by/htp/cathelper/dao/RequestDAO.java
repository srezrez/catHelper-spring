package by.htp.cathelper.dao;

import by.htp.cathelper.entity.Request;
import by.htp.cathelper.entity.Status;

import java.util.List;

public interface RequestDAO {

    List<Request> getAllUserRequests(int requesterId, int statusId);
    void saveRequest(Request request);
    List<Request> getActiveRequests(int catId);
    Request getRequest(int requestId);
}
