package by.htp.cathelper.controller;

import by.htp.cathelper.service.RequestService;
import by.htp.cathelper.viewmodel.RequestViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/showCatRequest")
    public String showCatRequest(@RequestParam("catId") int catId, Model model) {
        RequestViewModel requestViewModel = requestService.getCurrentRequest(catId);
        model.addAttribute("request", requestViewModel);
        return "cat-request";
    }

    @RequestMapping("/requestDecision")
    public String requestDecision(@RequestParam("requestId") int requestId, @RequestParam("decision") String decision){
        requestService.setRequestDecision(requestId, decision);
        return "home";
    }
}
