package by.htp.cathelper.service;

import by.htp.cathelper.dao.CatDAO;
import by.htp.cathelper.entity.Cat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatService {

    List<Cat> getAllFreeCats();
    List<Cat> getAddedCats(int ownerId);

}
