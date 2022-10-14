package ony.store.controllers;

import ony.store.dao.PartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("options",partDAO.getOptions());
        return "select/start";
    }
    @GetMapping("/model")
    public String selectModel(){

        return "select/select_model";
    }
}
