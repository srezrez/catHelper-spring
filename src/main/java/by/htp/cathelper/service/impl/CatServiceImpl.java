package by.htp.cathelper.service.impl;

import by.htp.cathelper.dao.CatDAO;
import by.htp.cathelper.entity.Cat;
import by.htp.cathelper.entity.Request;
import by.htp.cathelper.viewmodel.AddedCatViewModel;
import by.htp.cathelper.viewmodel.CatViewModel;
import by.htp.cathelper.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatDAO catDAO;

    @Transactional
    @Override
    public List<CatViewModel> getAllFreeCats() {
        List<Cat> cats = catDAO.getAllFreeCats();
        List<CatViewModel> catViewModels = createCatViewModelList(cats);
        return catViewModels;
    }

    @Transactional
    @Override
    public List<AddedCatViewModel> getAddedCats(int ownerId) {
        List<Cat> cats = catDAO.getAddedCats(ownerId);
        List<AddedCatViewModel> addedCatViewModels = createAddedCatViewModelList(cats);
        return addedCatViewModels;
    }

    @Transactional
    @Override
    public CatViewModel getCatInfo(int catId) {
        Cat cat = catDAO.getCat(catId);
        CatViewModel catViewModel = new CatViewModel();
        catViewModel.setId(cat.getId());
        catViewModel.setName(cat.getName());
        catViewModel.setAge(calculateAge(cat.getBirthDate()));
        catViewModel.setDescription(cat.getDescription());
        catViewModel.setGender(cat.getGender());
        catViewModel.setBreed(cat.getBreed());
        catViewModel.setOwnerId(cat.getOwner().getId());
        catViewModel.setDocument(cat.getDocuments().get(0));
        return catViewModel;
    }

    private List<CatViewModel> createCatViewModelList(List<Cat> cats) {
        List<CatViewModel> catViewModels;
        catViewModels = cats.stream().map(x -> {
            CatViewModel catViewModel = new CatViewModel();
            catViewModel.setId(x.getId());
            catViewModel.setName(x.getName());
            catViewModel.setAge(calculateAge(x.getBirthDate()));
            catViewModel.setBreed(x.getBreed());
            catViewModel.setGender(x.getGender());
            catViewModel.setDocument(x.getDocuments().get(0));
            catViewModel.setDescription(x.getDescription());
            catViewModel.setOwnerId(x.getOwner().getId());
            return catViewModel;
        }).collect(Collectors.toList());
        return catViewModels;
    }

    private List<AddedCatViewModel> createAddedCatViewModelList(List<Cat> cats) {
        List<AddedCatViewModel> addedCatViewModels;
        addedCatViewModels = cats.stream().map(x -> {
            AddedCatViewModel addedCatViewModel = new AddedCatViewModel();
            addedCatViewModel.setCat(x);
            addedCatViewModel.setAge(calculateAge(x.getBirthDate()));
            addedCatViewModel.setActiveRequestsAmount(calculateActiveRequestAmount(x.getRequests()));
            return addedCatViewModel;
        }).collect(Collectors.toList());
        return addedCatViewModels;
    }

    private String calculateAge(Date date) {
        int years = Period.between(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), java.time.LocalDate.now()).getYears();
        if (years == 0) {
            int months = Period.between(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), java.time.LocalDate.now()).getMonths();
            return months + " (месяцев)";
        }
        return years + " (лет)";
    }

    private int calculateActiveRequestAmount(List<Request> requests){
        int activeReqAmount = 0;
        for(Request req: requests){
            if(req.getStatus().getKey().equals("REQUEST_CREATED")) {
                activeReqAmount++;
            }
        }
        return activeReqAmount;
    }
}
