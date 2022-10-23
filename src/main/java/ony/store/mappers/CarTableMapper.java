
package ony.store.mappers;

        import ony.store.dto.Car;
        import org.springframework.jdbc.core.RowMapper;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class CarTableMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();

//        car.setBrandId(rs.getInt("brand_id"));
//        car.setModelId(rs.getInt("model_id"));
//        car.setBodyTypeId(rs.getInt("body_id"));
//        car.setMotorTypeId(rs.getInt("engine_id"));

        car.setId(rs.getInt("id"));

        return car;
    }
}
