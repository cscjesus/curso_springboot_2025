package edu.leon.service;
import edu.leon.model.Categoria;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
//@Primary
public class CategoriasServiceImpl  implements ICategoriasService {

    private List<Categoria> lista = null;

    public CategoriasServiceImpl() {
        lista = new LinkedList<Categoria>();

        // Creamos algunas Categorias para poblar la lista ...

        // Categoria 1
        Categoria cat1 = new Categoria(
        "Contabilidad","Descripcion de la categoria Contabilidad");

        // Categoria 2
        Categoria cat2 = new Categoria("Ventas","Trabajos relacionados con Ventas");


        // Categoria 3
        Categoria cat3 = new Categoria("Comunicaciones","Trabajos relacionados con Comunicaciones");

        // Categoria 4
        Categoria cat4 = new Categoria("Arquitectura","Trabajos de Arquitectura");

        // Categoria 5
        Categoria cat5 = new Categoria("Educacion","Maestros, tutores, etc");

        /**
         * Agregamos los 5 objetos de tipo Categoria a la lista ...
         */
        lista.add(cat1);
        lista.add(cat2);
        lista.add(cat3);
        lista.add(cat4);
        lista.add(cat5);
        lista.add(new Categoria("Desarrollo de software","Trabajo de programador"));

    }

    public void guardar(Categoria categoria) {
        lista.add(categoria);
    }

    public List<Categoria> buscarTodas() {
        return lista;
    }

    public Categoria buscarPorId(Integer idCategoria) {
        for (Categoria cat : lista) {
            if (cat.getId()==idCategoria) {
                return cat;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer idCategoria) {

    }

}
