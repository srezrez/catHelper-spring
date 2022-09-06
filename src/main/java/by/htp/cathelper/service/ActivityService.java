package by.htp.cathelper.service;

import by.htp.cathelper.entity.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ActivityService {

    List<Activity> getAll();
}
