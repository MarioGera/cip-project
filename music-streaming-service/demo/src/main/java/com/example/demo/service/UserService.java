package com.example.demo.service;

import com.example.demo.model.Playlist;
import com.example.demo.model.Song;
import com.example.demo.model.User;
import com.example.demo.repository.PlaylistRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public Playlist createPlaylist(Long userId,String playlistName){
        User user = getUserById(userId);
        Playlist playlist = new Playlist();
        playlist.setName(playlistName);
        playlist.setUser(user);
        return playlistRepository.save(playlist);
    }

    public List<Playlist>getUserPlaylists(Long userId) {
        User user = getUserById(userId);
        return user.getPlaylists();
    }
    public Playlist addSongToPlaylist(Long playlistId, Song song){
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new RuntimeException("Playlist not found"));
        playlist.getSongs().add(song);
        return playlistRepository.save(playlist);
    }
    public Playlist removeSongFromPlaylist(Long playlistId,Long songId){
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new RuntimeException("Playlist not found"));
        playlist.getSongs().removeIf(song -> song.getId().equals(songId));
        return playlistRepository.save(playlist);

    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
