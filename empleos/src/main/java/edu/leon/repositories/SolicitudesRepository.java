package edu.leon.repositories;

import edu.leon.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {
}

