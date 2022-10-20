package ony.store.controllers;

import ony.store.dao.PartDAO;
import ony.store.dto.CurrentPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Currency;

@Controller
@RequestMapping("/carforpart")
public class CarForPartController {

    PartDAO partDAO;
    @Autowired
    public CarForPartController(PartDAO partDAO) {
        this.partDAO = partDAO;
    }

    @GetMapping("/{partId}")
    public String carForPart(@PathVariable("partId") int partId, Model model){

        model.addAttribute(partDAO.getSinglePart(partId));
        return "carforpart/carforpart";
    }
}
