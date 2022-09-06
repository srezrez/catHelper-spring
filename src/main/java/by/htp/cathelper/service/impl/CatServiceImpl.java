package by.htp.cathelper.service.impl;

import by.htp.cathelper.dao.CatDAO;
import by.htp.cathelper.entity.Cat;
import by.htp.cathelper.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatDAO catDAO;

    @Transactional
    @Override
    public List<Cat> getAllFreeCats() {
        return catDAO.getAllFreeCats();
    }

    @Transactional
    @Override
    public List<Cat> getAddedCats(int ownerId) {
        return catDAO.getAddedCats(ownerId);
    }
}
