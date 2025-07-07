package edu.leon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class HomeController {
    @GetMapping("/")
    public String mostrartHome(Model model){
        model.addAttribute("mensaje","Bienvenidos a Empleos App");
        model.addAttribute("fecha", LocalDateTime.now());
        return "home";
    }
}
