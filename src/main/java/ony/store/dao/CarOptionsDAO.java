package ony.store.dao;

import ony.store.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CarOptionsDAO {


private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarOptionsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private CarDTO currentQuery = new CarDTO();
    public CarDTO getCurrentQuery() {
        return currentQuery;
    }

    public void setCurrentQuery(CarDTO currentQuery) {
        this.currentQuery = currentQuery;
    }




    public List<CarDTO> getOptionsBrands(){

        String SQL ="SELECT * FROM BRANDS";

       return jdbcTemplate.query(SQL, new CarDTOMapper());
    }

    public List<CarDTO> getOptionsModels(){

        String SQL ="SELECT * FROM MODELS";

       return jdbcTemplate.query(SQL, new CarDTOMapper());
    }

    public List<CarDTO> getOptionsEngines(){

        String SQL ="SELECT * FROM ENGINES";

       return jdbcTemplate.query(SQL, new CarDTOMapper());
    }

    public List<CarDTO> getOptionsBodies(){

        String SQL ="SELECT * FROM Bodies";

        return jdbcTemplate.query(SQL, new CarDTOMapper());
    }
}
