package com.example.demo.controller;

import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import com.example.demo.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = artistService.getAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist){
        Artist newArtist = artistService.createArtist(artist);
        return new ResponseEntity<>(newArtist, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        Artist artist = artistService.getArtistById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        Artist updatedArtist = artistService.updateArtist(id, artist);
        return new ResponseEntity<>(updatedArtist, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Artist>> searchArtistsByName(@RequestParam String name) {
        List<Artist> artists = artistService.searchArtistsByName(name);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/{id}/songs")
    public ResponseEntity<List<Song>> getSongsByArtist(@PathVariable Long id) {
        List<Song> songs = artistService.getSongsByArtist(id);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
}
