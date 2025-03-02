package com.rasel.first_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DummyController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/square")
    public int square(@RequestParam int number){
        return number * number;
    }

    @GetMapping("/rasel")
    public String rasel(@RequestParam String me, @RequestParam String father){
        return "i'm "+me+". my father name"+father;
    }
}
