package com.example.baitaph2buoi1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Web {
    @GetMapping("/")
    public String getHome(){
        return "redirect:/companies";
    }
}
