package ony.store.dao;

import ony.store.dto.Car;
import ony.store.dto.Part;
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

    public List<String> getBrandsOptions(){

        String SQL= "select name from brands";

        return jdbcTemplate.query(SQL, new CarBrandsMapper());

    }
    public List<String> getModelsOptions(Car car){

        String SQL= "select name from models WHERE brand_id IN (SELECT ID FROM BRANDS WHERE NAME=?)";

        return jdbcTemplate.query(SQL, new Object[]{car.getBrand()}, new CarModelsMapper());

    }
    public List<String> getEnginesOptions(Car car){

        String SQL= "select name from engines WHERE model_id IN (SELECT ID FROM MODELS WHERE NAME =?)";

        return jdbcTemplate.query(SQL, new Object[]{car.getModel()}, new CarEnginesMapper());

    }
    public List<String> getBodiesOptions(Car car){

        String SQL= "select name from bodies";

        return jdbcTemplate.query(SQL, new CarBodiesMapper());

    }

}
