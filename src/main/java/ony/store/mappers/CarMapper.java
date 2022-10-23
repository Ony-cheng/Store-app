package ony.store.mappers;

import ony.store.dto.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
//        car.setId(rs.getInt("cars_id"));
        car.setBrand(rs.getString("brands_name"));
        car.setModel(rs.getString("models_name"));
        car.setMotorType(rs.getString("engines_name"));
        car.setBodyType(rs.getString("bodies_name"));
//        car.setBrandId(rs.getInt("id"));
//        car.setModelId(rs.getInt("id"));
//        car.setBodyTypeId(rs.getInt("id"));
//        car.setMotorTypeId(rs.getInt("id"));

        return car;
    }
}
