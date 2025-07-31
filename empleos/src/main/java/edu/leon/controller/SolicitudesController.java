package edu.leon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudesController {
    @GetMapping("/create/{idVacante}")
    public String crear(@PathVariable Integer idVacante, Model model){
        System.out.println(idVacante);
        return "solicitudes/formSolicitud";
    }
}
