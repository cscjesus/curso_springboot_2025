package edu.leon.controller;

import edu.leon.model.Vacante;
import edu.leon.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/vacantes")
public class VacantesController {

    @Autowired
    private IVacanteService serviceVacantes;

    @GetMapping("/create")
    public String crear() {
        return "vacantes/formVacante";
    }

    @PostMapping("/save")
    public String guardar(Vacante vacante) {
        return "vacantes/listVacantes";
    }
//    @PostMapping("/save")
//    public String guardar(
//
//            @RequestParam("nombre") String nombre,
//            @RequestParam("descripcion") String descripcion,
//            @RequestParam("estatus") String estatus,
//            @RequestParam("fecha") String fecha,
//            @RequestParam("destacado") int destacado,
//            @RequestParam("salario") double salario,
//            @RequestParam("detalles") String detalles
//
//    ) {
//        System.out.println("nombre: " + nombre);
//        System.out.println("descripcion: " + descripcion);
//        System.out.println("estatus: " + estatus);
//        System.out.println("fecha: " + fecha);
//        System.out.println("destacado: " + destacado);
//        System.out.println("salario: " + salario);
//        System.out.println("detalles: " + detalles);
//        return "vacantes/listVacantes";
//    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model) {
        System.out.println("eliminando " + idVacante);
        model.addAttribute("id", idVacante);
        return "mensaje";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model) {

        Vacante vacante = serviceVacantes.buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);

        System.out.println("Vacante: " + vacante);

        return "detalle";
    }
}
