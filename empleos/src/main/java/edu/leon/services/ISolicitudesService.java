package edu.leon.services;

import edu.leon.model.Solicitud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISolicitudesService {
    void guardar(Solicitud solicitud);
    void eliminar(Integer idSolicitud);
    List<Solicitud> buscarTodas();
    Solicitud buscarPorId(Integer idSolicitud);
    Page<Solicitud> buscarTodas(Pageable  pageable);
}
