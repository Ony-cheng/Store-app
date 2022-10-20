package ony.store.dao;

import ony.store.dto.Car;
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

        public List<Car> getAllOptions(Car optionSet){


        String SQL ="select brands.name, models.name, engines.name, bodies.name" +
                    "from brands " +
                    "join models on brands.id=models.brand_id";
            return jdbcTemplate.query(SQL, new CarDTOMapper());
        }

}
