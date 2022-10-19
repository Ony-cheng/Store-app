package ony.store.dto;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String modification;
    private String motorType;
    private String bodyType;

    private int brandId;
    private int modelId;
    private int motorTypeId;
    private int bodyTypeId;
    private int modificationId;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getMotorTypeId() {
        return motorTypeId;
    }

    public void setMotorTypeId(int motorTypeId) {
        this.motorTypeId = motorTypeId;
    }

    public int getBodyTypeId() {
        return bodyTypeId;
    }

    public void setBodyTypeId(int bodyTypeId) {
        this.bodyTypeId = bodyTypeId;
    }

    public int getModificationId() {
        return modificationId;
    }

    public void setModificationId(int modificationId) {
        this.modificationId = modificationId;
    }

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
