package dao;

import entity.Wine;
import util.AppUtil;

public class WineDao {
    private Wine[] wines = new Wine[2];
    public void arrayLarge() {
        Wine[] winesLarge = new Wine[wines.length*2];
        System.arraycopy (wines, 0, winesLarge, 0, wines.length);
        wines = winesLarge;
    }

    public void create(Wine wine) {
        arrayLarge();
        for(int i = 0; i < wines.length; ++i) {
            if (wines[i] == null) {
                String id = AppUtil.getUUID();
                wine.setId(id);
                wines[i] = wine;
                break;
            }
        }
    }

    public void update(Wine wine) {
        if (wine.getYear() <= 0) {
            System.out.println("Incorrect year");
        } else {
            System.out.println("Year was update");
        }
    }

    public void delete(String id) {
        for(int i = 0; i < wines.length; ++i) {
            try {
                if (wines[i].getId().equals(id)) {
                    wines[i] = null;
                    System.out.println("Wine was delete");
                }
            } catch (Exception var4) {
                ++i;
            }
        }
    }

    public Wine findOne(String id) {
        for(int i = 0; i < wines.length; ++i) {
            Wine wine = wines[i];
            if (wine != null && wine.getId().equals(id)) {
                return wine;
            }
        }
        return null;
    }

    public Wine[] findAll() {
        return wines;
    }
}
