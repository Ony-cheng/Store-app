package ony.store.controllers;

import ony.store.dao.CarDAO;
import ony.store.dao.PartDAO;
import ony.store.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/carforpart")
public class CarForPartController {

    PartDAO partDAO;
    CarDAO carDAO;
    @Autowired
    public CarForPartController(PartDAO partDAO, CarDAO carDAO) {
        this.partDAO = partDAO;
        this.carDAO = carDAO;
    }

    @GetMapping("/{partId}")
    public String carForPart(@PathVariable Map <String, String> fromPath,
                             @ModelAttribute Car car, Model model){

        int partId = Integer.parseInt(fromPath.get("partId"));



        model.addAttribute(partDAO.getSinglePart(partId));
        model.addAttribute("cars",carDAO.getCarsForPart(partId));

        model.addAttribute("brandOtions",carDAO.getBrandsOptions());
        model.addAttribute("modelOptions",carDAO.getModelsOptions(car));
        model.addAttribute("enginesOptions",carDAO.getEnginesOptions(car));
        model.addAttribute("bodiesOptions",carDAO.getBodiesOptions(car));

        return "carforpart/carforpart";
    }

    @PostMapping("/add/{partId}")
    public String addCarToPart(@ModelAttribute Car car, @PathVariable int partId){
        partDAO.addCarToPart(car,partId);

        return "redirect:/carforpart/{partId}";
    }
}
