package com.example.demo.service;

import com.example.demo.model.Playlist;
import com.example.demo.model.Song;
import com.example.demo.repository.PlaylistRepository;
import com.example.demo.repository.SongRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private SongRepository songRepository;

    public Optional<Playlist> getPlaylistById(Long id) {
        return playlistRepository.findById(id);
    }

    public void deletePlaylist(Long id){
        playlistRepository.deleteById(id);
    }

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Playlist addSongToPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new RuntimeException("Playlist not found"));
        Song songToAdd = songRepository.findById(songId).orElseThrow(() -> new RuntimeException("Song not found"));
        playlist.getSongs().add(songToAdd);
        return playlistRepository.save(playlist);
    }

    public Playlist removeSongFromPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new RuntimeException("Playlist not found"));
        playlist.getSongs().removeIf(song -> song.getId().equals(songId));
        return playlistRepository.save(playlist);
    }

    public List<Playlist> getPlaylistsBySongId(Long songId) {
        return playlistRepository.findAllBySongs_Id(songId);
    }
}
