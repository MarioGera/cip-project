package com.example.demo.service;

import com.example.demo.model.Library;
import com.example.demo.model.Song;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.SongRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @Transactional
    public Song createSong(Song song) {
        Library library = libraryRepository.findById(1L).orElse(new Library());
        song.setLibrary(library);
        return songRepository.save(song);
    }
    @Transactional
    public Song updateSong(Long id,Song updatedSong){
        Song existingSong = songRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Song not found with id: " + id));
        existingSong.setId(updatedSong.getId());
        existingSong.setArtist(updatedSong.getArtist());
        existingSong.setName(updatedSong.getName());
        existingSong.setGenre(updatedSong.getGenre());
        existingSong.setSongDuration(updatedSong.getSongDuration());
        existingSong.setHasFeature(updatedSong.isHasFeature());
        return songRepository.save(existingSong);
    }
    @Transactional
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
    public Song getSongById(Long id){
        return songRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Song not found with id: " + id));
    }


}
