package ony.store.controllers;

import ony.store.dto.CurrentPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Currency;

@Controller
@RequestMapping("/carforpart")
public class CarForPartController {

CurrentPart currentPart;

    @Autowired
    public CarForPartController(CurrentPart currentPart) {
        this.currentPart = currentPart;
    }

    @GetMapping
    public String carForPart(@ModelAttribute CurrentPart currentPart, Model model){

        return "carforpart/carforpart";
    }
}
