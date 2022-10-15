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

    @Autowired
    public PartsController(PartDAO partDAO) {
        this.partDAO = partDAO;
    }


    @GetMapping
    public String selectBrand(@ModelAttribute CarDTO carDTO, Model model){

        model.addAttribute("options",partDAO.getOptions());
        return "select/start";
    }
    @GetMapping("/model")
    public String selectModel(@ModelAttribute CarDTO carDTO, Model model){
        partDAO.currentQuery.setBrand(carDTO.getBrand());
        model.addAttribute("options",partDAO.getOptions());
        return "select/select_model";
    }
    @GetMapping("/engine")
    public String selectEngine(@ModelAttribute CarDTO carDTO, Model model){
        partDAO.currentQuery.setModel(carDTO.getModel());
        model.addAttribute("currentQuery", partDAO.currentQuery);
        model.addAttribute("options",partDAO.getOptions());
        return "select/selectEngine";
    }
    @GetMapping("/body")
    public String selectBody(@ModelAttribute CarDTO carDTO, Model model) {
        partDAO.currentQuery.setMotorType(carDTO.getMotorType());
        model.addAttribute("currentQuery", partDAO.currentQuery);
        model.addAttribute("options", partDAO.getOptions());
        return "select/body";
    }
    @GetMapping("/mod")
    public String selectModification(@ModelAttribute CarDTO carDTO, Model model){
        partDAO.currentQuery.setBodyType(carDTO.getBodyType());
        model.addAttribute("currentQuery", partDAO.currentQuery);
        model.addAttribute("options", partDAO.getOptions());
       return "select/modification";

    }
    @GetMapping("/category")
    public String selectCategory(@ModelAttribute CarDTO carDTO, Model model){
        partDAO.currentQuery.setModification(carDTO.getModification());
        model.addAttribute("currentQuery", partDAO.currentQuery);
        return "select/category";

    }
}
