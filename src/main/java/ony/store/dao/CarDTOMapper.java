package ony.store.dao;

import ony.store.dto.CarDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDTOMapper implements RowMapper<CarDTO> {
    @Override
    public CarDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand(rs.getString("name"));
        return carDTO;
    }
}
