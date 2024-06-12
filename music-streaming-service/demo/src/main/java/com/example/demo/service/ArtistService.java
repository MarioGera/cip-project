package com.example.demo.service;

import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import com.example.demo.repository.ArtistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    @Transactional
    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Transactional
    public Artist updateArtist(Long id,Artist updatedArtist) {
        Artist existingArtist=artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Artist not found"));
        existingArtist.setAge(updatedArtist.getAge());
        existingArtist.setBio(updatedArtist.getBio());
        existingArtist.setArtistName(updatedArtist.getArtistName());
        existingArtist.setName(updatedArtist.getName());
        return artistRepository.save(existingArtist);
    }

    @Transactional
    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
    public Artist getArtistById(Long id){
        return artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Playlist not found"));
    }

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public List<Artist> searchArtistsByName(String name) {
        return artistRepository.findArtistsByName(name);
    }

    public List<Song> getSongsByArtist(Long id) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Artist not found"));
        return artist.getSongs();
    }


}
