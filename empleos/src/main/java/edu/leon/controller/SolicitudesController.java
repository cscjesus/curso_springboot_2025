package edu.leon.controller;

import edu.leon.model.Solicitud;
import edu.leon.model.Vacante;
import edu.leon.services.IVacanteService;
import edu.leon.services.db.VacantesServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudesController {
    @Autowired
    IVacanteService vacantesService;

    @GetMapping("/create/{idVacante}")
    public String crear(Solicitud solicitud, @PathVariable Integer idVacante, Model model){
        Vacante vacante = vacantesService.buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);
//        solicitud.setVacante(vacante);
        System.out.println(idVacante);
        return "solicitudes/formSolicitud";
    }

    @PostMapping("/save")
    public String guardar(Solicitud solicitud){
        System.out.println("Solicitud: " + solicitud);
        return "redirect:/";
    }
}
