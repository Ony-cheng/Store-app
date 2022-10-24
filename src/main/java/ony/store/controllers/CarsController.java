package ony.store.controllers;


import ony.store.dao.CarDAO;
import ony.store.dao.PartDAO;
import ony.store.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/search")
public class CarsController {
    PartDAO partDAO;
    CarDAO carDAO;
    @Autowired
    public CarsController(PartDAO partDAO, CarDAO carDAO) {
        this.partDAO = partDAO;
        this.carDAO = carDAO;
    }

    @GetMapping()
    public String search(@ModelAttribute Car car, Model model){

        model.addAttribute("brandOtions",carDAO.getBrandsOptions());
        model.addAttribute("modelOptions",carDAO.getModelsOptions(car));
        model.addAttribute("enginesOptions",carDAO.getEnginesOptions(car));
        model.addAttribute("bodiesOptions",carDAO.getBodiesOptions(car));

        return "search/search";
    }

}
