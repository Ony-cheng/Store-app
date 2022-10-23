package ony.store.mappers;

import ony.store.dto.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarBrandsMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setBrand(rs.getString("name"));
        car.setBrandId(rs.getInt("id"));
        return car;
    }
}
