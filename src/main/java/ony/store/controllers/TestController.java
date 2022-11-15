package ony.store.controllers;

import ony.store.services.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    TestService testService = new TestService();

    @GetMapping("/test")
    public String test(){

        testService.testMethod();

        return "test";
    }

}
