package ony.store.controllers;

import ony.store.dao.PartDAO;
import ony.store.dto.CurrentQuery;
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
    @GetMapping("/new")
    public String newPart(@ModelAttribute("part") Part part){

        return "parts/new";
    }

    @PostMapping("/create")
    public String createPart(@ModelAttribute("part") Part part){
        System.out.println("Name "+ part.getName() +
                            " PN "+ part.getPartNumber() +
                            " Description " + part.getDescription() +
                            " URL " + part.getImageURL() +
                            " Price" + part.getPrice());

        return "redirect:/carforpart/" + partDAO.createPart(part);
    }

}
