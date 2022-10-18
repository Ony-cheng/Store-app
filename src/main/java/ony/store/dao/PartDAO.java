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

    public CarDTO currentQuery = new CarDTO();


// SELECT NAME FROM MODELS WHERE brand_id IN (SELECT ID FROM BRANDS WHERE NAME = 'Ford');

    public List<CarDTO> getOptions(String tableName, CarDTO carDTO){

       String SQL=String.format("SELECT * FROM BRANDS");
       switch (tableName){
           case "BRANDS": SQL=String.format("SELECT * FROM %s",tableName) ; break;
           case "MODELS": SQL =
                   "SELECT NAME FROM MODELS WHERE brand_id IN (SELECT ID FROM BRANDS WHERE NAME = '"
                           + carDTO.getBrand() + "')";
           break;
           case "ENGINES":SQL =
                   "SELECT NAME FROM ENGINES WHERE model_id IN (SELECT ID FROM MODELS WHERE NAME = '"
                           + carDTO.getModel() + "')";
           break;
       }

        return jdbcTemplate.query(SQL, new CarDTOMapper());
    }



}
