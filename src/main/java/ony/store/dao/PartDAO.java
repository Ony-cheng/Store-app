package ony.store.dao;

import ony.store.dto.Car;
import ony.store.dto.Part;
import ony.store.mappers.CarTableMapper;
import ony.store.mappers.PartDTOMapper;
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



    public List<Part> getParts(Car currentQuery){

        if(currentQuery.getBrand()== null ||
                currentQuery.getModel()== null ||
        currentQuery.getMotorType()== null ||
        currentQuery.getBodyType() == null){
            return null;
        }

        String   SQL="select *" +
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


        return jdbcTemplate.query(SQL, new Object[]{currentQuery.getBrand(), currentQuery.getModel(),
        currentQuery.getMotorType(), currentQuery.getBodyType()}, new PartDTOMapper());
    }

    public List<Part> getPartsByName (String query){
        if(query==null){
            return null;
        }
        String SQL = "select * from parts where lower (name) like lower ( ? )";
        return jdbcTemplate.query(SQL, new Object[]{"%" + query + "%"}, new PartDTOMapper());
    }

    public int createPart(Part part){
    String SQL = "insert into parts(name, partnumber, description,  image_url, price)" +
            "values(?,?,?,?,?)";
        jdbcTemplate.update(SQL, part.getName(), part.getPartNumber(),part.getDescription(),part.getImageURL(),
                part.getPrice());
        SQL= "select id from parts where partnumber=?";

        int partId= (int) jdbcTemplate.queryForObject(SQL, new Object[] {part.getPartNumber()}, Integer.class);

        return partId;
    }

    public Part getSinglePart(int Id){

       String SQL= "select * from parts where id=?";

        return jdbcTemplate.query(SQL, new Object[]{Id}, new PartDTOMapper()).get(0);
    }

    public void addCarToPart(Car car, int partId){

        String SQL;

        SQL= "select id from cars where (brand_id=? AND model_id=? AND engine_id=? AND body_id=?)";


        List<Car> anewCar = jdbcTemplate.query(SQL, new Object[]{car.getBrandId(), car.getModelId(),car.getMotorTypeId(),car.getBodyTypeId()},
                new CarTableMapper());
        if(anewCar.isEmpty()){
            SQL = "insert into cars(brand_id, model_id, engine_id, body_id)" +
                    "values(?,?,?,?)";
            jdbcTemplate.update(SQL, car.getBrandId(), car.getModelId(),car.getMotorTypeId(),car.getBodyTypeId());
        }

        SQL= "select id from cars where (brand_id=? AND model_id=? AND engine_id=? AND body_id=?)";
        int carId  = jdbcTemplate.query(SQL, new Object[]{car.getBrandId(), car.getModelId(),car.getMotorTypeId(),car.getBodyTypeId()},
                new CarTableMapper()).get(0).getId();


        SQL = "insert into cars_to_parts(car_id, part_id) values(?,?)";


        jdbcTemplate.update(SQL, carId, partId);


    }


}
