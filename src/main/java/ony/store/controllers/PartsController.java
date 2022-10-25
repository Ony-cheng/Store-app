package ony.store.controllers;

import ony.store.dao.PartDAO;
import ony.store.dto.Car;
import ony.store.dto.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parts")
public class PartsController {


    PartDAO partDAO;
    @Autowired
    public PartsController( PartDAO partDAO) {
              this.partDAO = partDAO;
    }


    @GetMapping("/new")
    public String newPart(@ModelAttribute("part") Part part){

        return "parts/new";
    }

    @PostMapping("/create")
    public String createPart(@ModelAttribute("part") Part part){

        return "redirect:/carforpart/" + partDAO.createPart(part);
    }

}
