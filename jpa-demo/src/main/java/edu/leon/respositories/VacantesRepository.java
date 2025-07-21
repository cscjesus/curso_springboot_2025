package edu.leon.respositories;

import edu.leon.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacantesRepository extends JpaRepository<Vacante,Integer> {
}
