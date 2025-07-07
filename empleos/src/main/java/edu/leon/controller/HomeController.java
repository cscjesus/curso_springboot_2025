package edu.leon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class HomeController {
    @GetMapping("/")
    public String mostrartHome(Model model){
//        model.addAttribute("mensaje","Bienvenidos a Empleos App");
//        model.addAttribute("fecha", LocalDateTime.now());
        String nombre = "Auxiliar de Contabilidad";
        LocalDate fechaPub = LocalDate.now();
        double salario = 9000;
        boolean vigente = true;
        model.addAttribute("nombre", nombre);
        model.addAttribute("fecha", fechaPub);
        model.addAttribute("salario", salario);
        model.addAttribute("vigente", vigente);
        return "home";
        //seccion 2 video 8
    }
}
