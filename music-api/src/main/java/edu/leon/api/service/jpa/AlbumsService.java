package edu.leon.api.service.jpa;

import edu.leon.api.entity.Album;
import edu.leon.api.repository.AlbumsRepository;
import edu.leon.api.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumsService implements IAlbumService {
    @Autowired
    private AlbumsRepository albumsRepository;

    @Override
    public List<Album> buscarTodos() {
        return albumsRepository.findAll();
    }

    @Override
    public void guardar(Album album) {
        albumsRepository.save(album);
    }
}
