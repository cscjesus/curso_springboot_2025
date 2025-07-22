package edu.leon.respositories;

import edu.leon.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacantesRepository extends JpaRepository<Vacante,Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    List<Vacante> findByEstatus(String estatus);
    List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(Integer destacado, String estatus);
    List<Vacante>  findBySalarioBetweenOrderBySalarioDesc(Double salario, Double salario2);
    List<Vacante> findByEstatusIn(List<String> estatus);
}
