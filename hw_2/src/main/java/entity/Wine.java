package entity;

public class Wine extends BaseEntity {
    private String brand;
    private String grapes;
    private int year;

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGrapes() {
        return this.grapes;
    }

    public void setGrapes(String grapes) {
        this.grapes = grapes;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }
}