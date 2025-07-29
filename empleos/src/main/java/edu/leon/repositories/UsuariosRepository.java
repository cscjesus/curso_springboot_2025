package edu.leon.repositories;

import edu.leon.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByUsername(String username);
}
