package edu.leon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/listado")
    public String mostrarListado(Model model){
        List<String> lista = new LinkedList<>();
        lista.add("Ingeniero de Sistemas");
        lista.add("Auxiliar de Contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");

        model.addAttribute("empleos",lista);

        return "listado";
    }
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
        //seccion 2 video 9
    }
}
