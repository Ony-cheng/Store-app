package ony.store.controllers;

import ony.store.dao.PartDAO;
import ony.store.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/select")
public class PartsController {

    PartDAO partDAO;

    CarDTO currentQuery = new CarDTO();
    @Autowired
    public PartsController(PartDAO partDAO) {
        this.partDAO = partDAO;
    }


    @GetMapping
    public String selectBrand(@ModelAttribute CarDTO carDTO, Model model){

        model.addAttribute("options",partDAO.getOptions("BRANDS",carDTO));
        return "select/start";
    }
    @GetMapping("/model")
    public String selectModel(@ModelAttribute CarDTO carDTO, Model model){
        currentQuery.setBrand(carDTO.getBrand());
        model.addAttribute("currentQuery", currentQuery);
        model.addAttribute("options",partDAO.getOptions("MODELS", carDTO));
        return "select/select_model";
    }
    @GetMapping("/engine")
    public String selectEngine(@ModelAttribute CarDTO carDTO, Model model){
        currentQuery.setModel(carDTO.getModel());
        model.addAttribute("currentQuery", currentQuery);
        model.addAttribute("options",partDAO.getOptions("ENGINES",carDTO));
        return "select/selectEngine";
    }
    @GetMapping("/body")
    public String selectBody(@ModelAttribute CarDTO carDTO, Model model) {
        currentQuery.setMotorType(carDTO.getMotorType());
        model.addAttribute("currentQuery", currentQuery);
        model.addAttribute("options", partDAO.getOptions("BODIES",carDTO));
        return "select/body";
    }
//    @GetMapping("/mod")
//    public String selectModification(@ModelAttribute CarDTO carDTO, Model model){
//        currentQuery.setBodyType(carDTO.getBodyType());
//        model.addAttribute("currentQuery", partDAO.currentQuery);
//        model.addAttribute("options", partDAO.getOptions("BODIES",carDTO));
//       return "select/modification";
//
//    }
    @GetMapping("/category")
    public String selectCategory(@ModelAttribute CarDTO carDTO, Model model){

        currentQuery.setBodyType(carDTO.getBodyType());
        model.addAttribute("currentQuery", currentQuery);
        return "select/category";

    }
}
