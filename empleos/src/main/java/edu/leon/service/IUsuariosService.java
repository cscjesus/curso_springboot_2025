package edu.leon.service;

import edu.leon.model.Usuario;

import java.util.List;

public interface IUsuariosService {
    void guardar(Usuario usuario);
    void eliminar(Integer idUsuario);
    List<Usuario> buscarTodos();
    Usuario buscarPorUsername(String username);
}
