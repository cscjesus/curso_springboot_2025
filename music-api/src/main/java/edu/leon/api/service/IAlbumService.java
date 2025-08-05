package edu.leon.api.service;

import edu.leon.api.entity.Album;

import java.util.List;

public interface IAlbumService {
    List<Album> buscarTodos();
    void guardar(Album album);
}
