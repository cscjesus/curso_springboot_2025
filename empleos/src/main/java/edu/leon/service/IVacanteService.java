package edu.leon.service;

import edu.leon.model.Vacante;

import java.util.List;

public interface IVacanteService {
    List<Vacante> buscarTodas();
    Vacante buscarPorId(Integer id);
    void guardar(Vacante vacante);
    List<Vacante> buscarDestacadas();
    void eliminar(Integer id);
}
