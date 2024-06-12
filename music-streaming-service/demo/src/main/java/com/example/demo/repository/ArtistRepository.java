package com.example.demo.repository;

import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist,Long> {

    public List<Artist> findArtistsByName(String name);
}
