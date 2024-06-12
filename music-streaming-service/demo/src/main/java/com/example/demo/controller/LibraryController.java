package com.example.demo.controller;

import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = libraryService.getAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = libraryService.getAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @DeleteMapping("/songs/{id}")
    public ResponseEntity<Void> deleteSongFromLibrary(@PathVariable Long id) {
        libraryService.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
