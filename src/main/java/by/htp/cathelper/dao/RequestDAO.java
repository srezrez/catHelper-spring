package by.htp.cathelper.dao;

import by.htp.cathelper.entity.Request;
import by.htp.cathelper.entity.Status;

import java.util.List;

public interface RequestDAO {

    List<Request> getAllUserRequests(int requesterId, int statusId);
}
