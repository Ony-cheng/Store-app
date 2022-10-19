package ony.store.controllers;

import ony.store.dao.PartDAO;
import ony.store.dto.CurrentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parts")
public class PartsController {

    CurrentQuery currentQuery;
    PartDAO partDAO;
    @Autowired
    public PartsController(CurrentQuery currentQuery, PartDAO partDAO) {
        this.currentQuery = currentQuery;
        this.partDAO = partDAO;
    }



    @GetMapping
    public String showParts(Model model){

        model.addAttribute("currentQuery", currentQuery);
        model.addAttribute("parts", partDAO.getParts(currentQuery));

        return "parts/show";
    }
}
