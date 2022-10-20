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

        SQL="select *" +
                " from parts" +
                " join cars_to_parts on cars_to_parts.part_id=parts.id" +
                " join cars on cars.id=cars_to_parts.car_id" +
                " join brands on brands.id=cars.brand_id" +
                " join models on models.id=cars.model_id" +
                " join engines on engines.id=cars.engine_id" +
                " join bodies on bodies.id = cars.body_id" +
                " where (brands.name = ?" +
                " AND models.name= ? " +
                " AND engines.name = ? " +
                " AND bodies.name = ? )";
        System.out.println("Brand is "+currentQuery.getBrand()+ " id is "+ currentQuery.getBrandId());
        return jdbcTemplate.query(SQL, new Object[]{currentQuery.getBrand(), currentQuery.getModel(),
        currentQuery.getMotorType(), currentQuery.getBodyType()}, new PartDTOMapper());
    }

    public void createPart(Part part){

//        jdbcTemplate.query();
    }
}
