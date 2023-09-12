package service;

import dao.WineDao;
import entity.Wine;

public class WineService {
    private WineDao wineDao = new WineDao();

    public WineService() {
    }

    public void create(Wine wine) {
        if (wine.getYear() <= 0) {
            System.out.println("incorrect year");
        } else {
            this.wineDao.create(wine);
        }

    }

    public void update(Wine wine) {
        this.wineDao.update(wine);
    }

    public void delete(String id) {
        this.wineDao.delete(id);
    }

    public Wine findById(String id) {
        return this.wineDao.findOne(id);
    }

    public Wine[] findAll() {
        return this.wineDao.findAll();
    }
}