package ony.store.dao;

import ony.store.dto.CarDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PartDAO {

    private final List<CarDTO> carOptions = new ArrayList<CarDTO>();

    public CarDTO currentQuery = new CarDTO();

    {
        carOptions.add(new CarDTO(
                1, "Daewoo", "Lanos", "Sport", "4.5 turbo", "Coupe"));
        carOptions.add(new CarDTO(
                2, "Daewoo", "Lanos", "Cruise missle", "Jet", "Паляниця"));
        carOptions.add(new CarDTO(
                3, "Daewoo", "Lanos", "Dwarf destroyer", "0.5", "Hetchback"));
        carOptions.add(new CarDTO(
                4, "Daewoo", "Sens", "Sport", "1.2", "Sedan"));
        carOptions.add(new CarDTO(
                5, "Ford", "Focus", "Your mom", "1.6", "Wagon"));
        carOptions.add(new CarDTO(
                6, "Ford", "Fiesta", "Roadster", "1.6", "Sedan"));
        carOptions.add(new CarDTO(
                7, "Ford", "Mustang", "GT", "8.8", "Coupe"));
    }
    public List<String> getBrandOptions(){

    List<String> brandOptions = new ArrayList<String>();

       for(int i=0;i<carOptions.size();i++){
           brandOptions.add(carOptions.get(i).getBrand()) ;
       }

    return brandOptions;
    }

    public List<CarDTO> getOptions(){
        return carOptions;
    }



}
