package by.htp.cathelper.controller;

import by.htp.cathelper.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @RequestMapping("/sendRequest")
    public String sendRequest(@RequestParam("catId") int catId) {
        System.out.println("CAT ID:" + catId);
        requestService.saveRequest(catId, 2);
        return "home";
    }
}
