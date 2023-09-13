package dao;

import entity.Wine;
import java.util.UUID;

public class WineDao {
    private Wine[] wines = new Wine[2];
    public void arrayLarge() {
        Wine[] winesLarge = new Wine[wines.length*2];
        System.arraycopy (wines, 0, winesLarge, 0, wines.length);
        wines = winesLarge;
    }

    public void create(Wine wine) {
        arrayLarge();
        for(int i = 0; i < this.wines.length; ++i) {
            if (this.wines[i] == null) {
                String id = UUID.randomUUID().toString();
                wine.setId(id);
                this.wines[i] = wine;
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
        for(int i = 0; i < this.wines.length; ++i) {
            try {
                if (this.wines[i].getId().equals(id)) {
                    this.wines[i] = null;
                    System.out.println("Wine was delete");
                }
            } catch (Exception var4) {
                ++i;
            }
        }
    }

    public Wine findOne(String id) {
        for(int i = 0; i < this.wines.length; ++i) {
            Wine wine = this.wines[i];
            if (wine != null && wine.getId().equals(id)) {
                return wine;
            }
        }
        return null;
    }

    public Wine[] findAll() {
        return this.wines;
    }
}
