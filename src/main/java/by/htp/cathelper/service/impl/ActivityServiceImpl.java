package by.htp.cathelper.service.impl;

import by.htp.cathelper.dao.ActivityDAO;
import by.htp.cathelper.entity.Activity;
import by.htp.cathelper.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDAO activityDAO;

    @Transactional
    @Override
    public List<Activity> getAll() {
        return activityDAO.getAll();
    }
}
