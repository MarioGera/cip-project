package com.example.demo.repository;

import com.example.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Long> {

}

