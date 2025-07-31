package edu.leon.services;

import edu.leon.model.Categoria;

import java.util.List;

public interface ICategoriasService {
    void guardar(Categoria categoria) ;
    List<Categoria> buscarTodas();
    Categoria buscarPorId(Integer idCategoria);
    void eliminar(Integer idCategoria);
}
