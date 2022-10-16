package ony.store.dao;

import ony.store.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PartDAO {


private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PartDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CarDTO getCurrentQuery() {
        return currentQuery;
    }

    public void setCurrentQuery(CarDTO currentQuery) {
        this.currentQuery = currentQuery;
    }

    private CarDTO currentQuery = new CarDTO();


//

    public List<CarDTO> getOptions(){
       return jdbcTemplate.query("SELECT * FROM BRANDS", new CarDTOMapper());
    }



}
