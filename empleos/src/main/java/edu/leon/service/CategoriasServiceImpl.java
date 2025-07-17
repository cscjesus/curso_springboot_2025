package edu.leon.service;
import edu.leon.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CategoriasServiceImpl  implements ICategoriasService {

    private List<Categoria> lista = null;

    public CategoriasServiceImpl() {
        lista = new LinkedList<Categoria>();

        // Creamos algunas Categorias para poblar la lista ...

        // Categoria 1
        Categoria cat1 = new Categoria(
        1,"Contabilidad","Descripcion de la categoria Contabilidad");

        // Categoria 2
        Categoria cat2 = new Categoria(2,"Ventas","Trabajos relacionados con Ventas");


        // Categoria 3
        Categoria cat3 = new Categoria(3,"Comunicaciones","Trabajos relacionados con Comunicaciones");

        // Categoria 4
        Categoria cat4 = new Categoria(4,"Arquitectura","Trabajos de Arquitectura");

        // Categoria 5
        Categoria cat5 = new Categoria(5,"Educacion","Maestros, tutores, etc");

        /**
         * Agregamos los 5 objetos de tipo Categoria a la lista ...
         */
        lista.add(cat1);
        lista.add(cat2);
        lista.add(cat3);
        lista.add(cat4);
        lista.add(cat5);

    }

    public void guardar(Categoria categoria) {
        lista.add(categoria);
    }

    public List<Categoria> buscarTodas() {
        return lista;
    }

    public Categoria buscarPorId(Integer idCategoria) {
        for (Categoria cat : lista) {
            if (cat.id()==idCategoria) {
                return cat;
            }
        }
        return null;
    }

}
