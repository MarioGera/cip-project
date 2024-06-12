package com.example.demo.controller;

import com.example.demo.model.Song;
import com.example.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        Song newSong = songService.createSong(song);
        return new ResponseEntity<>(newSong, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        Song song = songService.getSongById(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody Song song) {
        Song existingSong = songService.getSongById(id);
        if (existingSong == null || !existingSong.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        song.setId(id);
        Song updatedSong = songService.updateSong(id, song);
        return new ResponseEntity<>(updatedSong, HttpStatus.OK);
    }
}
