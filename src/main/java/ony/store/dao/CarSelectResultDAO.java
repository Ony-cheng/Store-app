package ony.store.dao;

import ony.store.dto.CarDTO;
import org.springframework.stereotype.Component;

@Component
public class CarSelectResultDAO extends CarDTO{

    CarDTO currentQuery = new CarDTO();

    public CarDTO getCurrentQuery() {
        return currentQuery;
    }


}
