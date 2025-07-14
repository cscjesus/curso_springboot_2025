package edu.leon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {
    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        return "categorias/listCategorias";
    }
    @GetMapping("/create")
    public String crear(){
        return  "categorias/formCategoria";
    }


    @PostMapping("/save")
    public String guardar(@RequestParam("nombre") String nombre,@RequestParam("descripcion") String descripcion){
        System.out.println("Categoria:"+nombre);
        System.out.println("Descripcion:"+descripcion);
        return "categorias/listCategorias";
    }

    @GetMapping("/detalle/{id}")
    public String mostrarDetalle(@PathVariable("id") int idVacante){
        System.out.println("PathVariable: "+idVacante);
        return "categorias/listCategoria";
    }
}
