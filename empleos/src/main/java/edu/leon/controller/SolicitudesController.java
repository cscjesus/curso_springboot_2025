package edu.leon.controller;

import edu.leon.model.Solicitud;
import edu.leon.model.Usuario;
import edu.leon.model.Vacante;
import edu.leon.services.ISolicitudesService;
import edu.leon.services.IUsuariosService;
import edu.leon.services.IVacanteService;
import edu.leon.services.db.VacantesServiceJpa;
import edu.leon.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudesController {

    @Value("${empleosapp.ruta.cv}")
    private String rutaCv;

    @Autowired
    IVacanteService vacantesService;

    @Autowired
    IUsuariosService usuariosService;

    @Autowired
    ISolicitudesService  solicitudesService;

    @GetMapping("/indexPaginate")
    public String mostrarIndexPaginate(Model model, Pageable page){
        Page<Solicitud> lista = solicitudesService.buscarTodas(page);
        model.addAttribute("solicitudes",lista);
        return "solicitudes/listSolicitudes";
    }
    @GetMapping("/create/{idVacante}")
    public String crear(Solicitud solicitud, @PathVariable Integer idVacante, Model model) {
        Vacante vacante = vacantesService.buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);
//        solicitud.setVacante(vacante);
        System.out.println(idVacante);
        return "solicitudes/formSolicitud";
    }

    @PostMapping("/save")
    public String guardar(Solicitud solicitud, BindingResult bindingResult, @RequestParam("archivoCV") MultipartFile multipart, Authentication authentication, RedirectAttributes attributes) {
        String username = authentication.getName();

        if (bindingResult.hasErrors()) {
            System.out.println("Existen errores en el formulario");
            return "solicitudes/formSolicitud";
        }
        if (!multipart.isEmpty()) {
            String nombreArchivo = Utileria.guardarArchivo(multipart, rutaCv);

            if (nombreArchivo != null) {
                solicitud.setArchivo(nombreArchivo);
            } else {
                System.out.println("Error al guardar el archivo");
            }
        }
        Usuario usuario = usuariosService.buscarPorUsername(username);
        solicitud.setUsuario(usuario);

        solicitudesService.guardar(solicitud);
        attributes.addFlashAttribute("msg","Gracias por enviar tu CV");
        System.out.println("Solicitud: " + solicitud);
        return "redirect:/";
    }
}
