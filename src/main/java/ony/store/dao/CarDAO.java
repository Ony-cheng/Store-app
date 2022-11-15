package ony.store.dao;

import ony.store.entities.Car;

import java.util.List;

public interface CarDAO {

    void add(Car car);

    List<Car> getAll();

    Car getById();

    void updateBrand(String brand, int id);

    void updateModel(String model, int id);

    void remove(int id);
}
