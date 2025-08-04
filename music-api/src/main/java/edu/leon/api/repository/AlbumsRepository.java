package edu.leon.api.repository;

import edu.leon.api.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<Album,Integer> {
}
