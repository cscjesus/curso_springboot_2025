package edu.leon.services;

import edu.leon.model.Vacante;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IVacanteService {
    List<Vacante> buscarTodas();
    Vacante buscarPorId(Integer id);
    void guardar(Vacante vacante);
    List<Vacante> buscarDestacadas();
    void eliminar(Integer id);
    List<Vacante> buscarByExample(Example<Vacante> example);
    Page<Vacante> buscarTodas(Pageable pageable);
}
