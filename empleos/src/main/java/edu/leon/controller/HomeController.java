package edu.leon.controller;

import edu.leon.model.Perfil;
import edu.leon.model.Usuario;
import edu.leon.model.Vacante;
import edu.leon.service.ICategoriasService;
import edu.leon.service.IUsuariosService;
import edu.leon.service.IVacanteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private IVacanteService serviceVacantes;
    @Autowired
    private IUsuariosService serviceUsuarios;
    @Autowired
    private ICategoriasService serviceCategorias;

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Vacante vacante = new Vacante(0, "Ingeniero de Comunicaciones", "Se solicita Ing. para dar soporte a intranet", LocalDate.now(), 9700.0, 0, "no-omage.png", null, null,
                null);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        List<String> lista = new LinkedList<>();
        lista.add("Ingeniero de Sistemas");
        lista.add("Auxiliar de Contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");

        model.addAttribute("empleos", lista);

        return "listado";
    }

    @GetMapping("/")
    public String mostrartHome(Model model) {
        return "home";
    }


    @GetMapping("/signup")
    public String registrarse(Usuario usuario) {
        return "formRegistro";
    }

    @PostMapping("/signup")
    public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {
        usuario.setEstatus(1); // Activado por defecto
        usuario.setFechaRegistro(LocalDate.now()); // Fecha de Registro, la fecha actual del servidor

        // Creamos el Perfil que le asignaremos al usuario nuevo
        Perfil perfil = new Perfil();
        perfil.setId(3); // Perfil USUARIO
        usuario.agregar(perfil);

        /**
         * Guardamos el usuario en la base de datos. El Perfil se guarda automaticamente
         */
        serviceUsuarios.guardar(usuario);

        attributes.addFlashAttribute("msg", "El registro fue guardado correctamente!");

        return "redirect:/usuarios/index";
    }

    @GetMapping("/search")
    public String buscar(@ModelAttribute("search") Vacante vacante, Model model) {
        System.out.println("Buscar: " + vacante);
        ExampleMatcher matcher = ExampleMatcher.matching()
                //where descripcion like '%?%'
                .withMatcher("descripcion", ExampleMatcher.GenericPropertyMatchers.contains()).withIgnoreCase();


        Example<Vacante> example = Example.of(vacante, matcher);
        var lista = serviceVacantes.buscarByExample(example);
        model.addAttribute("vacantes", lista);
        return "home";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @ModelAttribute
    public void setGenericos(Model model) {
        var vacanteSearch = new Vacante();
        vacanteSearch.reset();
        model.addAttribute("vacantes", serviceVacantes.buscarDestacadas());
        model.addAttribute("categorias", serviceCategorias.buscarTodas());
        model.addAttribute("search", vacanteSearch);
    }

    @GetMapping("/index")
    public String mostrarIndex(Authentication authentication, HttpSession session) {
        String username = authentication.getName();
        System.out.println("Usuario autenticado: " + username);

        authentication.getAuthorities().forEach(auth -> {
            System.out.println("Rol: " + auth.getAuthority());
        });

        if(session.getAttribute("username") != null)
            return "redirect:/";

        Usuario usuario = serviceUsuarios.buscarPorUsername(username);
        usuario.setPassword(null);
        session.setAttribute("usuario", usuario);
        System.out.println(usuario);
        return "redirect:/";
    }
}
