package ony.store.controllers;

import ony.store.dao.PartDAO;
import ony.store.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/carselect")
public class CarSelector {


    PartDAO partDAO;

    @Autowired
    public CarSelector(PartDAO partDAO) {
        this.partDAO = partDAO;
    }

    @RequestMapping(value = "/{categoryName}", method = RequestMethod.GET)
    public String carSelector(@PathVariable String categoryName, Model model, CarDTO carDTO){

        model.addAttribute("options",partDAO.getOptions(categoryName,carDTO));

        System.out.println(categoryName);

    return "carselect/carselect";
    }
}
