package by.htp.cathelper.service;

import by.htp.cathelper.entity.Request;
import by.htp.cathelper.entity.Status;

import java.util.List;

public interface RequestService {

    List<Request> getAllUserRequests(int requesterId, int statusId);
}
