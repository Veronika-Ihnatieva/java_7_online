package entity;

public abstract class BaseEntity {
    private String id;

    public BaseEntity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}