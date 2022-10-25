package ony.store.controllers;

import ony.store.dao.CarDAO;
import ony.store.dao.PartDAO;
import ony.store.dto.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manage")
public class ManageController {

    PartDAO partDAO;
    CarDAO carDAO;
    @Autowired
    public ManageController(PartDAO partDAO, CarDAO carDAO) {
        this.partDAO = partDAO;
        this.carDAO = carDAO;
    }

    @GetMapping
    public String managementPage(@RequestParam(required = false) String searchQuery, Model model){

        model.addAttribute("partsname",partDAO.getPartsByName(searchQuery));
        return "manage/management";
    }

    @GetMapping("/edit/{Id}")
    public String editPart(@PathVariable int Id, Model model){
        System.out.println("We are in controller " + Id);

         model.addAttribute("part", partDAO.getSinglePart(Id));
        return "manage/edit";

    }
    @PostMapping("/update")
    public String updatePart(@ModelAttribute Part part){
        System.out.println("Part name is "+ part.getName());
        return "redirect:/";
    }
}
