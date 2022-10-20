package ony.store.controllers;

import ony.store.dao.CarDAO;
import ony.store.dao.PartDAO;
import ony.store.dto.Car;
import ony.store.dto.CurrentPart;
import ony.store.dto.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Currency;
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




    @GetMapping("/{partId/{brand}/{model}/{engine}/{body}")
    public String carForPart(@PathVariable Map <String, String> fromPath,
                             @ModelAttribute Car car, Model model){

        Car optionSet = new Car();
        optionSet.setBrand(fromPath.get("brand"));
        optionSet.setModel(fromPath.get("model"));
        optionSet.setMotorType(fromPath.get("engine"));
        optionSet.setBodyType(fromPath.get("body"));

        int partId = Integer.parseInt(fromPath.get("partId"));

        model.addAttribute(partDAO.getSinglePart(partId));


        return "carforpart/carforpart";
    }
}
