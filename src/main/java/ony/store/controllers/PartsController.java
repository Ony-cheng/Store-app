package ony.store.controllers;

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

    @Autowired
    public PartsController(CurrentQuery currentQuery) {
        this.currentQuery = currentQuery;
    }
    @GetMapping
    public String showParts(Model model){

        model.addAttribute("currentQuery", currentQuery);
        return "parts/show";
    }
}
