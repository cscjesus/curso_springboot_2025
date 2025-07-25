package edu.leon.service;

import edu.leon.model.Vacante;
import org.springframework.data.domain.Example;

import java.util.List;

public interface IVacanteService {
    List<Vacante> buscarTodas();
    Vacante buscarPorId(Integer id);
    void guardar(Vacante vacante);
    List<Vacante> buscarDestacadas();
    void eliminar(Integer id);
    List<Vacante> buscarByExample(Example<Vacante> example);
}
