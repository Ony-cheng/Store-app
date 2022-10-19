package ony.store.dao;

import ony.store.dto.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDTOMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setBrand(rs.getString("name"));
        car.setModel(rs.getString("name"));
        car.setMotorType(rs.getString("name"));
        car.setBodyType(rs.getString("name"));
        car.setBrandId(rs.getInt("id"));
        car.setModelId(rs.getInt("id"));
        car.setBodyTypeId(rs.getInt("id"));
        car.setMotorTypeId(rs.getInt("id"));
        return car;
    }
}
