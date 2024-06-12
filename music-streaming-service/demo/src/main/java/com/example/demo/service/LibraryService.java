package com.example.demo.service;

import com.example.demo.model.Artist;
import com.example.demo.model.Library;
import com.example.demo.model.Playlist;
import com.example.demo.model.Song;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.PlaylistRepository;
import com.example.demo.repository.SongRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Song> getAllSongs() {
        Library library = libraryRepository.findById(1L).orElseThrow(() -> new RuntimeException("Library not found"));
        return library.getSongs();
    }

    public Library getLibrary() {
        return libraryRepository.findById(1L).orElseThrow(() -> new RuntimeException("Library not found"));
    }

    public Song addNewSong(String title, Long artistId) {
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new RuntimeException("Artist not found"));
        Song newSong = new Song();
        newSong.setName(title);
        newSong.setArtist(artist);
        return songRepository.save(newSong);
    }

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public void deleteSong(Long id) {
        Optional<Song> songOptional = songRepository.findById(id);
        if (songOptional.isEmpty()) {
            throw new EntityNotFoundException("Song not found with id: " + id);
        }
        Song song = songOptional.get();
        Artist artist = song.getArtist();
        artist.getSongs().remove(song);
        artistRepository.save(artist);
        Library library = song.getLibrary();
        library.getSongs().remove(song);
        List<Playlist> playlists = playlistRepository.findAllBySongs_Id(id);
        for (Playlist playlist : playlists) {
            playlist.getSongs().remove(song);
        }
        songRepository.deleteById(id);
    }
}
