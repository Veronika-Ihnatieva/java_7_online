package controller;
import entity.Wine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import service.WineService;
import util.AppUtil;

public class WineController {
    private WineService wineService = new WineService();

    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to The Wine Catalog!");
        System.out.println("Please, select your options:");
        String select;
        menu();

        while((select = bufferedReader.readLine()) != null) {
            crud(bufferedReader, select);
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("If you want to create wine, please, enter 1");
        System.out.println("If you want to update wine, please, enter 2");
        System.out.println("If you want to delete wine, please, enter 3");
        System.out.println("If you want to find wine, please, enter 4");
        System.out.println("If you want to find all wine, please, enter 5");
        System.out.println("If you want to close The Catalog, please, enter 6");
    }

    private void crud(BufferedReader bufferedReader, String select) throws IOException {
        switch (select) {
            case "1" -> create(bufferedReader);
            case "2" -> update(bufferedReader);
            case "3" -> delete(bufferedReader);
            case "4" -> findOne(bufferedReader);
            case "5" -> findAll(bufferedReader);
            case "6" -> System.exit(0);
        }
        menu();
    }

    public void create(BufferedReader bufferedReader) throws IOException {
        System.out.println("Please, add wine brand");
        String brand = bufferedReader.readLine();
        System.out.println("Please, add wine grapes");
        String grapes = bufferedReader.readLine();
        System.out.println("Please, wine year");
        String yearString = bufferedReader.readLine();
        int year = Integer.parseInt(yearString);
        Wine wine = new Wine();
        wine.setBrand(brand);
        wine.setGrapes(grapes);
        wine.setYear(year);
        wineService.create(wine);
    }

    private void update(BufferedReader bufferedReader) throws IOException {
        System.out.println(AppUtil.FIND_BY_ID_MESSAGE);
        String id = bufferedReader.readLine();
        Wine wine = wineService.findById(id);
        if (wine != null) {
            System.out.println("You want to update this wine:  Id: " + wine.getId() + ", Brand: " + wine.getBrand() + ", Grapes: " + wine.getGrapes() + ", Year: " + wine.getYear());
            System.out.println("Indicate which parameter:");
            System.out.println("Brand, please, enter 1");
            System.out.println("Grapes, please, enter 2");
            System.out.println("Year, please, enter 3");
            System.out.println("If you want to close The Catalog, please, enter 4");
            String yearString;
            switch (bufferedReader.readLine()) {
                case "1" -> {
                    System.out.println("Please, add wine brand");
                    yearString = bufferedReader.readLine();
                    wine.setBrand(yearString);
                    System.out.println("Brand was update");
                }
                case "2" -> {
                    System.out.println("Please, add wine grapes");
                    yearString = bufferedReader.readLine();
                    wine.setGrapes(yearString);
                    System.out.println("Grapes was update");
                }
                case "3" -> {
                    System.out.println("Please, wine year");
                    yearString = bufferedReader.readLine();
                    int year = Integer.parseInt(yearString);
                    wine.setYear(year);
                    this.wineService.update(wine);
                }
                case "4" -> {
                    System.exit(0);
                }
            }
        }
    }

    private void delete(BufferedReader bufferedReader) throws IOException {
        System.out.println(AppUtil.FIND_BY_ID_MESSAGE);
        String id = bufferedReader.readLine();
        Wine wine = wineService.findById(id);
        if (wine != null) {
            System.out.println("Do you really want to delete this wine from the catalog? Id: " + wine.getId() + ", Brand: " + wine.getBrand() + ", Grapes: " + wine.getGrapes() + ", Year: " + wine.getYear());
            System.out.println("Yes, please, enter 1");
            System.out.println("No, please, enter 2");
            System.out.println("If you want to close The Catalog, please, enter 3");
            switch (bufferedReader.readLine()) {
                case "1" -> wineService.delete(id);
                case "2" -> start();
                case "3" -> System.exit(0);
            }
        } else {
            System.out.println("Wine not found");
        }
    }

    private void findOne(BufferedReader bufferedReader) throws IOException {
        System.out.println(AppUtil.FIND_BY_ID_MESSAGE);
        String id = bufferedReader.readLine();
        Wine wine = wineService.findById(id);
        if (wine != null) {
            System.out.println("Id: " + wine.getId() + ", Brand: " + wine.getBrand() + ", Grapes: " + wine.getGrapes() + ", Year: " + wine.getYear());
        } else {
            System.out.println("Wine not found");
        }
    }

    private void findAll(BufferedReader bufferedReader) {
        Wine[] wines = wineService.findAll();

        for(int i = 0; i < wines.length; ++i) {
            Wine wine = wines[i];
            if (wine != null) {
                System.out.println("Id: " + wine.getId() + ", Brand: " + wine.getBrand() + ", Grapes: " + wine.getGrapes() + ", Year: " + wine.getYear());
            }
        }
    }
}
