package by.htp.cathelper.service.impl;

import by.htp.cathelper.dao.CatDAO;
import by.htp.cathelper.entity.Cat;
import by.htp.cathelper.entity.CatViewModel;
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
    public List<Cat> getAddedCats(int ownerId) {
        return catDAO.getAddedCats(ownerId);
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
            return catViewModel;
        }).collect(Collectors.toList());
        return catViewModels;
    }

    private String calculateAge(Date date) {
        int years = Period.between(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), java.time.LocalDate.now()).getYears();
        if (years == 0) {
            int months = Period.between(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), java.time.LocalDate.now()).getMonths();
            return months + " (месяцев)";
        }
        return years + " (лет)";
    }
}
