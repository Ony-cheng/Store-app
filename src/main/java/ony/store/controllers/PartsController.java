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
    public String selectBrand(Model model){

        model.addAttribute("carDTO", new CarDTO());
        model.addAttribute("options",partDAO.getOptions());

        return "select/start";
    }
    @GetMapping("/model")
    public String selectModel(@ModelAttribute CarDTO carDTO, Model model){
        model.addAttribute("carDTO",carDTO);
        model.addAttribute("options",partDAO.getOptions());
        return "select/select_model";
    }
    @GetMapping("/engine")
    public String selectEngine(){
        return "select/selectEngine";
    }
}
