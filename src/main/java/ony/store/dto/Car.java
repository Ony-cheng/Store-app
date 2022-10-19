package ony.store.dto;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String modification;
    private String motorType;
    private String bodyType;

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public String getMotorType() {
        return motorType;
    }

    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public Car(int id, String brand, String model, String modification, String motorType, String bodyType) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.modification = modification;
        this.motorType = motorType;
        this.bodyType = bodyType;
    }
}
