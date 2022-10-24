package ony.store.dao;

import ony.store.dto.Car;
import ony.store.mappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CarDAO {


private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Car> getOptions(String tableName, Car car){

       String SQL=String.format("SELECT * FROM %s",tableName);
       switch (tableName){
           case "BRANDS": SQL=String.format("SELECT * FROM %s",tableName) ; break;
           case "MODELS": SQL =
                   "SELECT * FROM MODELS WHERE brand_id IN (SELECT ID FROM BRANDS WHERE NAME = '"
                           + car.getBrand() + "')";
           break;
           case "ENGINES":SQL =
                   "SELECT * FROM ENGINES WHERE model_id IN (SELECT ID FROM MODELS WHERE NAME = '"
                           + car.getModel() + "')";
           break;
       }

        return jdbcTemplate.query(SQL, new CarDTOMapper());
    }

    public List<Car> getBrandsOptions(){

        String SQL= "select name, id from brands";

        return jdbcTemplate.query(SQL, new CarBrandsMapper());

    }
    public List<Car> getModelsOptions(Car car){


        String SQL= "select models.name, models.id from models join brands on models.brand_id=brands.id" +
                " WHERE (brands.name =? or brands.id=?)";

        return jdbcTemplate.query(SQL, new Object[]{car.getBrand(),car.getBrandId()},
                new CarModelsMapper());

    }
    public List<Car> getEnginesOptions(Car car){

        String SQL= "select engines.name, engines.id from engines join models" +
                " on models.id=engines.model_id" +
                " join brands on brands.id=models.brand_id" +
                " WHERE (models.name=? and brands.name=?) or (models.id=? and brands.id=?)";

        return jdbcTemplate.query(SQL, new Object[]{car.getModel(), car.getBrand(),
                car.getModelId(), car.getBrandId()},
                new CarEnginesMapper());

    }
    public List<Car> getBodiesOptions(Car car){

        String SQL= "select name, id from bodies";

        return jdbcTemplate.query(SQL, new CarBodiesMapper());

    }

    public List<Car> getCarsForPart(int partId){

        String SQL= "select cars.id cars_id, brands.name brands_name, models.name models_name," +
                " engines.name engines_name, bodies.name bodies_name from brands" +
                " join cars on brands.id = cars.brand_id" +
                " join models on models.id=cars.model_id" +
                " join engines on engines.id=cars.engine_id" +
                " join bodies on bodies.id = cars.body_id" +
                " join cars_to_parts on cars.id = cars_to_parts.car_id" +
                " where cars_to_parts.part_id = ?";

        return jdbcTemplate.query(SQL, new Object[]{partId}, new CarMapper());
    }
}
