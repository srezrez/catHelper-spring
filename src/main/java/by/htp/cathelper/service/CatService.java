package by.htp.cathelper.service;

import by.htp.cathelper.entity.Cat;
import by.htp.cathelper.viewmodel.AddedCatViewModel;
import by.htp.cathelper.viewmodel.CatViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatService {

    List<CatViewModel> getAllFreeCats();
    List<AddedCatViewModel> getAddedCats(int ownerId);
    CatViewModel getCatInfo(int catId);

}
