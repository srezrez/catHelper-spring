package by.htp.cathelper.controller;

import by.htp.cathelper.entity.Cat;
import by.htp.cathelper.entity.CatViewModel;
import by.htp.cathelper.entity.Request;
import by.htp.cathelper.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cat")
public class CatController {

    @Autowired
    private CatService catService;

    @RequestMapping("/showCatCatalog")
    public String catCatalog(Model model) {
        List<CatViewModel> cats = catService.getAllFreeCats();
        model.addAttribute("catList", cats);
        cats.forEach(System.out::println);
        return "cat-catalog";
    }

    @RequestMapping("/showCatInfo")
    public String catInfo(@RequestParam("catId") int catId, Model model) {
        System.out.println("catId: " + catId);
        CatViewModel catViewModel = catService.getCatInfo(catId);
        model.addAttribute("cat", catViewModel);
        return "cat-info";
    }
}
