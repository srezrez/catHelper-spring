package by.htp.cathelper.dao;

import by.htp.cathelper.entity.Cat;

import java.util.List;

public interface CatDAO {

    List<Cat> getAllFreeCats();
    List<Cat> getAddedCats(int ownerId);
    Cat getCat(int catId);
}
