package by.htp.cathelper.controller;

import by.htp.cathelper.entity.Activity;
import by.htp.cathelper.entity.Cat;
import by.htp.cathelper.entity.Request;
import by.htp.cathelper.service.ActivityService;
import by.htp.cathelper.service.CatService;
import by.htp.cathelper.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private CatService catService;
    @Autowired
    private RequestService requestService;

    @RequestMapping("/")
    public String home() {
//        List<Activity> activityList = activityService.getAll();
//        List<Cat> cats = catService.getAddedCats(2);
//        List<Request> requests = requestService.getAllUserRequests(2, 2);
//        requests.forEach(System.out::println);
        return "home";
    }
}
