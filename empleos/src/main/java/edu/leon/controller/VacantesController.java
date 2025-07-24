package edu.leon.controller;

import edu.leon.model.Vacante;
import edu.leon.service.CategoriasServiceImpl;
import edu.leon.service.ICategoriasService;
import edu.leon.service.IVacanteService;
import edu.leon.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping(value = "/vacantes")
public class VacantesController {

    @Value("${empleosapp.ruta.imagenes}")
    private String ruta;

    @Autowired
    private CategoriasServiceImpl categoriasServiceImpl;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(LocalDate.parse(text,DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
        });
    }

    @Autowired
    private IVacanteService serviceVacantes;

    @Autowired
    @Qualifier("categoriasServiceJpa")
    private ICategoriasService serviceCategorias;


    @GetMapping("/index")
    public String index(Model model) {
        var vacantes = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", vacantes);
        return "vacantes/listVacantes";
    }
    @GetMapping("/create")
    public String crear(Vacante vacante, Model model) {
        setGenericos(model);
//        model.addAttribute("vacante", vacante);
        return "vacantes/formVacante";
    }

    @PostMapping("/save")
    public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes, @RequestParam(value = "archivoImagen",required = false) MultipartFile multiPart) {
        System.out.println(vacante);
        if(result.hasErrors()){
            for( var error: result.getAllErrors()){
                System.out.println("Ocurrio un error: "+error.getDefaultMessage());
            }
            return "vacantes/formVacante";
        }
        if(!multiPart.isEmpty()){
            String nombreImagen = Utileria.guardarArchivo(multiPart,ruta);
            if(nombreImagen != null){
                vacante.setImagen(nombreImagen);
            }
        }
        serviceVacantes.guardar(vacante);
        System.out.println(vacante);
        attributes.addFlashAttribute("msg", "Registro Guardado");
        return "redirect:/vacantes/index";
    }


    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idVacante, RedirectAttributes attributes) {
        System.out.println("eliminando " + idVacante);
        serviceVacantes.eliminar(idVacante);
        attributes.addFlashAttribute("msg", "Vacante Eliminada");
        return "redirect:/vacantes/index";
    }
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int idVacante, Model model) {
        var vacante = serviceVacantes.buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);
       setGenericos(model);
        return "vacantes/formVacante";
    }
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model) {

        Vacante vacante = serviceVacantes.buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);

        System.out.println("Vacante: " + vacante);

        return "detalle";
    }
    @ModelAttribute
    public void setGenericos(Model model){
        model.addAttribute("categorias", serviceCategorias.buscarTodas());

    }
}
