package ony.store.controllers;

import ony.store.dao.CarDAO;
import ony.store.dto.Car;
import ony.store.dto.CurrentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/select")
public class CarSelectorController {

    CarDAO carDAO;

    CurrentQuery currentQuery;
    @Autowired
    public CarSelectorController(CarDAO carDAO, CurrentQuery currentQuery) {
        this.carDAO = carDAO;
        this.currentQuery = currentQuery;
    }

    @GetMapping
    public String selectBrand(@ModelAttribute Car car, Model model){

        model.addAttribute("options",carDAO.getOptions("BRANDS", car));
        return "select/start";
    }
    @GetMapping("/model")
    public String selectModel(@ModelAttribute Car car, Model model){
        currentQuery.setBrand(car.getBrand());
      
        model.addAttribute("currentQuery", currentQuery);
        model.addAttribute("options",carDAO.getOptions("MODELS", car));
        return "select/select_model";
    }
    @GetMapping("/engine")
    public String selectEngine(@ModelAttribute Car car, Model model){
        currentQuery.setModel(car.getModel());
        model.addAttribute("currentQuery", currentQuery);
        model.addAttribute("options",carDAO.getOptions("ENGINES", car));
        return "select/selectEngine";
    }
    @GetMapping("/body")
    public String selectBody(@ModelAttribute Car car, Model model) {
        currentQuery.setMotorType(car.getMotorType());
        model.addAttribute("currentQuery", currentQuery);
        model.addAttribute("options", carDAO.getOptions("BODIES", car));
        return "select/body";
    }

    @GetMapping("/category")
    public String selectCategory(@ModelAttribute Car carDAO, Model model){

        currentQuery.setBodyType(carDAO.getBodyType());
        model.addAttribute("currentQuery", currentQuery);
        return "redirect:/parts";

    }
}
