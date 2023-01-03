package ony.store.controllers;

import ony.store.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test")
    public String test(){

        testService.testMeth();
        return "test";
        //tthtf
    }

}
