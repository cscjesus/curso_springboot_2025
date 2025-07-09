package edu.leon.controller;

import edu.leon.model.Vacante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = getVacantes();
        model.addAttribute("vacantes",lista);
        return "tabla";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Vacante vacante = new Vacante(0, "Ingeniero de Comunicaciones", "Se solicita Ing. para dar soporte a intranet", LocalDate.now(), 9700.0,0,"no-omage.png");
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
    }

    /**
     * Metodo que regrsa una lista de objetos de tipo Vacante
     * @return
     */
    private List<Vacante> getVacantes() {
        List<Vacante> vacantes = new LinkedList<>();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var vacante1 = new Vacante(1,"Ingeniero Civil","Se solicita Ing. Civil para " +
                "disenar puente peatonal",LocalDate.parse("08-02-2019",df),8500.0,1,"empresa1.png");
        vacantes.add(vacante1);

        vacante1 = new Vacante(2,"Contador Publico","Empresa importante solicita contandor con 5 anios de experiencia titulado",LocalDate.parse("09-02-2019",df),12000.0,0,"empresa2.png");
        vacantes.add(vacante1);

        vacante1 = new Vacante(3,"Ingeniero Electrico","Empresa internacional solicita Ingeniero Electrico para mantenimiento de instalacion electrica",LocalDate.parse("10-02-2019",df),10500.0,0);
        vacantes.add(vacante1);

        vacante1 = new Vacante(4,"Disenador Grafico","Solicitamos Disenador Grafico titulado para disenar publicidad de la empresa",LocalDate.parse("01-02-2019",df),7500.0,1,"empresa3.png");

        vacantes.add(vacante1);

        return vacantes;
    }
}
