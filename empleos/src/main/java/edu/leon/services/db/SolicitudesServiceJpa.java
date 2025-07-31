package edu.leon.services.db;

import edu.leon.model.Solicitud;
import edu.leon.repositories.SolicitudesRepository;
import edu.leon.services.ISolicitudesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudesServiceJpa implements ISolicitudesService {
    @Autowired
    private SolicitudesRepository repo;

    @Override
    public void guardar(Solicitud solicitud) {
        repo.save(solicitud);
    }

    @Override
    public void eliminar(Integer idSolicitud) {
        repo.deleteById(idSolicitud);
    }

    @Override
    public List<Solicitud> buscarTodas() {
        return repo.findAll();
    }

    @Override
    public Solicitud buscarPorId(Integer idSolicitud) {
        return repo.findById(idSolicitud).orElse(null);
    }

    @Override
    public Page<Solicitud> buscarTodas(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
