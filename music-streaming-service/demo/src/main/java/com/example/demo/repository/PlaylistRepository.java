package com.example.demo.repository;

import com.example.demo.model.Artist;
import com.example.demo.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {

    List<Playlist> findAllBySongs_Id(Long songId);
}
