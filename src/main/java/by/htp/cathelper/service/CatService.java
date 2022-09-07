package by.htp.cathelper.service;

import by.htp.cathelper.dao.CatDAO;
import by.htp.cathelper.entity.Cat;
import by.htp.cathelper.entity.CatViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatService {

    List<CatViewModel> getAllFreeCats();
    List<Cat> getAddedCats(int ownerId);
    CatViewModel getCatInfo(int catId);

}
