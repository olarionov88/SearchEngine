package main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class DefaultController {

    @RequestMapping("/")
    public String index(){
        return "Random: " + new Random().nextInt(100000);
    }
}
