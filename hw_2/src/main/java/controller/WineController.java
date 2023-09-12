package controller;

import entity.Wine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import service.WineService;

public class WineController {
    private WineService wineService = new WineService();

    public WineController() {
    }

    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to The Wine Catalog!");
        System.out.println("Please, select your options:");
        this.menu();

        String select;
        while((select = bufferedReader.readLine()) != null) {
            this.crud(bufferedReader, select);
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
            case "1":
                this.create(bufferedReader);
                break;
            case "2":
                this.update(bufferedReader);
                break;
            case "3":
                this.delete(bufferedReader);
                break;
            case "4":
                this.findOne(bufferedReader);
                break;
            case "5":
                this.findAll(bufferedReader);
                break;
            case "6":
                System.exit(0);
        }

        this.menu();
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
        this.wineService.create(wine);
    }

    private void update(BufferedReader bufferedReader) throws IOException {
        System.out.println("Please, add id of wine");
        String id = bufferedReader.readLine();
        Wine wine = this.wineService.findById(id);
        if (wine != null) {
            PrintStream var10000 = System.out;
            String var10001 = wine.getId();
            var10000.println("You want to update this wine:  Id: " + var10001 + ", Brand: " + wine.getBrand() + ", Grapes: " + wine.getGrapes() + ", Year: " + wine.getYear());
            System.out.println("Indicate which parameter:");
            System.out.println("Brand, please, enter 1");
            System.out.println("Grapes, please, enter 2");
            System.out.println("Year, please, enter 3");
            System.out.println("If you want to close The Catalog, please, enter 4");
            String yearString;
            switch (bufferedReader.readLine()) {
                case "1":
                    System.out.println("Please, add wine brand");
                    yearString = bufferedReader.readLine();
                    wine.setBrand(yearString);
                    System.out.println("Brand was update");
                    break;
                case "2":
                    System.out.println("Please, add wine grapes");
                    yearString = bufferedReader.readLine();
                    wine.setGrapes(yearString);
                    System.out.println("Grapes was update");
                    break;
                case "3":
                    System.out.println("Please, wine year");
                    yearString = bufferedReader.readLine();
                    int year = Integer.parseInt(yearString);
                    wine.setYear(year);
                    this.wineService.update(wine);
                    break;
                case "4":
                    System.exit(0);
            }
        }

    }

    private void delete(BufferedReader bufferedReader) throws IOException {
        System.out.println("Please, add id of wine");
        String id = bufferedReader.readLine();
        Wine wine = this.wineService.findById(id);
        if (wine != null) {
            PrintStream var10000 = System.out;
            String var10001 = wine.getId();
            var10000.println("Do you really want to delete this wine from the catalog? Id: " + var10001 + ", Brand: " + wine.getBrand() + ", Grapes: " + wine.getGrapes() + ", Year: " + wine.getYear());
            System.out.println("Yes, please, enter 1");
            System.out.println("No, please, enter 2");
            System.out.println("If you want to close The Catalog, please, enter 3");
            switch (bufferedReader.readLine()) {
                case "1":
                    this.wineService.delete(id);
                    break;
                case "2":
                    this.start();
                    break;
                case "3":
                    System.exit(0);
            }
        } else {
            System.out.println("Wine not found");
        }

    }

    private void findOne(BufferedReader bufferedReader) throws IOException {
        System.out.println("Please, add id of wine");
        String id = bufferedReader.readLine();
        Wine wine = this.wineService.findById(id);
        if (wine != null) {
            PrintStream var10000 = System.out;
            String var10001 = wine.getId();
            var10000.println("Id: " + var10001 + ", Brand: " + wine.getBrand() + ", Grapes: " + wine.getGrapes() + ", Year: " + wine.getYear());
        } else {
            System.out.println("Wine not found");
        }

    }

    private void findAll(BufferedReader bufferedReader) {
        Wine[] wines = this.wineService.findAll();

        for(int i = 0; i < wines.length; ++i) {
            Wine wine = wines[i];
            if (wine != null) {
                PrintStream var10000 = System.out;
                String var10001 = wine.getId();
                var10000.println("Id: " + var10001 + ", Brand: " + wine.getBrand() + ", Grapes: " + wine.getGrapes() + ", Year: " + wine.getYear());
            }
        }

    }
}
