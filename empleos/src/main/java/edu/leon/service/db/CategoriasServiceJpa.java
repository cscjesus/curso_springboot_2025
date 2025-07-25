package edu.leon.service.db;

import edu.leon.model.Categoria;
import edu.leon.repositories.CategoriasRepository;
import edu.leon.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CategoriasServiceJpa implements ICategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Override
    public void guardar(Categoria categoria) {
    categoriasRepository.save(categoria);
    }

    @Override
    public List<Categoria> buscarTodas() {
        return categoriasRepository.findAll();
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        return categoriasRepository.findById(idCategoria)
                .orElse(null);
    }

    @Override
    public void eliminar(Integer idCategoria) {
        categoriasRepository.deleteById(idCategoria);
    }
}
