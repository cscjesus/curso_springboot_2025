package edu.leon.api.controller;


import edu.leon.api.entity.Album;
import edu.leon.api.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class AlbumsController {
    @Autowired
    private IAlbumService albumService;

    @GetMapping("/albums")
    public List<Album> buscarTodos() {
        return albumService.buscarTodos();
    }
    @PostMapping("/albums")
    public Album guardar(@RequestBody Album album) {
        albumService.guardar(album);
        return album;
    }
    @PutMapping("/albums")
    public Album modificar(@RequestBody Album album) {
        albumService.guardar(album);
        return album;
    }
}
