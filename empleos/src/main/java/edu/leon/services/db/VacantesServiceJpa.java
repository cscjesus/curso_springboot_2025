package edu.leon.services.db;

import edu.leon.model.Vacante;
import edu.leon.repositories.VacantesRepository;
import edu.leon.services.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public List<Vacante> buscarDestacadas() {
        return vacantesRepository.findByDestacadoAndEstatusOrderByIdDesc(1,"Aprobada");
    }

    @Override
    public void eliminar(Integer id) {
        vacantesRepository.deleteById(id);
    }

    @Override
    public List<Vacante> buscarByExample(Example<Vacante> example) {
        return vacantesRepository.findAll(example);
    }

    @Override
    public Page<Vacante> buscarTodas(Pageable page) {
        return vacantesRepository.findAll(page);
    }
}
