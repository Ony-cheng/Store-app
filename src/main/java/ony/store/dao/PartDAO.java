package ony.store.dao;

import ony.store.dto.Car;
import ony.store.dto.CurrentQuery;
import ony.store.dto.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PartDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PartDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Part> getParts(CurrentQuery currentQuery){


        String SQL="select * from parts\n" +
                "join cars on parts.car=cars.id\n" +
                "join brands on cars.brand_id=brands.id\n" +
                "where brands.name=?";
        System.out.println("Brand is "+currentQuery.getBrand()+ " id is "+ currentQuery.getBrandId());
        return jdbcTemplate.query(SQL, new Object[]{currentQuery.getBrand()}, new PartDTOMapper());
    }

    public void createPart(Part part){

    }
}
