package edu.leon.service.db;

import edu.leon.model.Usuario;
import edu.leon.repositories.UsuariosRepository;
import edu.leon.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceJpa implements IUsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepo;

    public void guardar(Usuario usuario) {
        usuariosRepo.save(usuario);
    }

    public void eliminar(Integer idUsuario) {
        usuariosRepo.deleteById(idUsuario);
    }

    public List<Usuario> buscarTodos() {
        return usuariosRepo.findAll();
    }

    @Override
    public Usuario buscarPorUsername(String username) {
        return usuariosRepo.findByUsername(username);
    }

}