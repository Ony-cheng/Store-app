package ony.store.controllers;


import ony.store.dao.CarDAO;
import ony.store.dao.PartDAO;
import ony.store.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping()
public class CarsController {
    PartDAO partDAO;
    CarDAO carDAO;
    @Autowired
    public CarsController(PartDAO partDAO, CarDAO carDAO) {
        this.partDAO = partDAO;
        this.carDAO = carDAO;
    }


@GetMapping("/search")
    public String search(@ModelAttribute Car car,
                         @RequestParam(required = false) String searchQuery, Model model){

        model.addAttribute("brandOtions",carDAO.getBrandsOptions());
        model.addAttribute("modelOptions",carDAO.getModelsOptions(car));
        model.addAttribute("enginesOptions",carDAO.getEnginesOptions(car));
        model.addAttribute("bodiesOptions",carDAO.getBodiesOptions(car));

        System.out.println("Query is " + searchQuery);

//        model.addAttribute(partDAO.getPartsByName(searchQuery))
        model.addAttribute("parts", partDAO.getParts(car));

        return "search/search";
    }

    @GetMapping("/search/text")
    public String search(@RequestParam String searchQuery){

        System.out.println("Query is 1" + searchQuery);

       return "redirect:/search/" + searchQuery;
    }
}
