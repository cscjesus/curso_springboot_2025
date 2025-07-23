package edu.leon.service.db;

import edu.leon.model.Vacante;
import edu.leon.repositories.VacantesRepository;
import edu.leon.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class VacantesServiceJpa implements IVacanteService {
    @Autowired
    private VacantesRepository  vacantesRepository;
    @Override
    public List<Vacante> buscarTodas() {
        return vacantesRepository.findAll();
    }

    @Override
    public Vacante buscarPorId(Integer id) {
        return vacantesRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Vacante vacante) {
        vacantesRepository.save(vacante);
    }
}
