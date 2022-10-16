package ony.store.controllers;

import ony.store.dao.CarOptionsDAO;
import ony.store.dao.CarSelectResultDAO;
import ony.store.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/select")
public class CarSelectController {

    CarOptionsDAO carOptionsDAO;
    CarSelectResultDAO carSelectResultDAO;

    @Autowired
    public CarSelectController(CarOptionsDAO carOptionsDAO, CarSelectResultDAO carSelectResultDAO) {
        this.carOptionsDAO = carOptionsDAO;
        this.carSelectResultDAO = carSelectResultDAO;
    }




    @GetMapping
    public String startSelection(@ModelAttribute CarDTO carDTO, Model model){

       if(carDTO.getBrand()!=null){
           carSelectResultDAO.setBrand(carDTO.getBrand());
           model.addAttribute("query",carSelectResultDAO.getCurrentQuery());
           model.addAttribute("options",carOptionsDAO.getOptionsModels());
           return "select/select_model";
       }
        if(carDTO.getModel()!=null){
            carSelectResultDAO.setModel(carDTO.getModel());
            System.out.println(carSelectResultDAO.getCurrentQuery().getBrand());
            model.addAttribute("query",carSelectResultDAO.getCurrentQuery());
            model.addAttribute("options",carOptionsDAO.getOptionsEngines());
            return "select/selectEngine";
        }
        if(carDTO.getMotorType()!=null){
            carSelectResultDAO.setModel(carDTO.getMotorType());
            model.addAttribute("query",carSelectResultDAO.getCurrentQuery());
            model.addAttribute("options",carOptionsDAO.getOptionsBodies());
            return "select/selectEngine";
        }
        model.addAttribute("options",carOptionsDAO.getOptionsBrands());
    return "select/start";
    }

}
