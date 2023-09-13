package service;

import dao.WineDao;
import entity.Wine;

public class WineService {
    private WineDao wineDao = new WineDao();

    public void create(Wine wine) {
        if (wine.getYear() <= 0) {
            System.out.println("incorrect year");
        } else {
            wineDao.create(wine);
        }
    }

    public void update(Wine wine) { wineDao.update(wine);}

    public void delete(String id) { wineDao.delete(id); }

    public Wine findById(String id) { return wineDao.findOne(id); }

    public Wine[] findAll() { return wineDao.findAll(); }
}