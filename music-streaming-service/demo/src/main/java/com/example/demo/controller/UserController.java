package com.example.demo.controller;

import com.example.demo.model.Playlist;
import com.example.demo.model.Song;
import com.example.demo.model.User;
import com.example.demo.service.PlaylistService;
import com.example.demo.service.SongService;
import com.example.demo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SongService songService;
    @Autowired
    private PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{userId}/playlists")
    public ResponseEntity<Playlist> createPlaylist(@PathVariable Long userId, @RequestParam String playlistName) {
        Playlist newPlaylist = userService.createPlaylist(userId, playlistName);
        return new ResponseEntity<>(newPlaylist, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/playlists")
    public ResponseEntity<List<Playlist>> getUserPlaylists(@PathVariable Long userId) {
        List<Playlist> userPlaylists = userService.getUserPlaylists(userId);
        return new ResponseEntity<>(userPlaylists, HttpStatus.OK);
    }

    @PostMapping("/{userId}/playlists/{playlistId}/songs")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable Long playlistId, @RequestParam Long songId) {
        Song song = songService.getSongById(songId);
        Playlist updatedPlaylist = userService.addSongToPlaylist(playlistId, song);
        return new ResponseEntity<>(updatedPlaylist, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/playlists/{playlistId}/songs/{songId}")
    public ResponseEntity<Playlist> removeSongFromPlaylist(@PathVariable Long playlistId, @PathVariable Long songId) {
        Playlist updatedPlaylist = userService.removeSongFromPlaylist(playlistId, songId);
        return new ResponseEntity<>(updatedPlaylist, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/playlists/{playlistId}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long playlistId) {
        Optional<Playlist> playlistOptional = playlistService.getPlaylistById(playlistId);
        if (playlistOptional.isEmpty()) {
            throw new EntityNotFoundException("Playlist not found with id: " + playlistId);
        }
        Playlist playlist = playlistOptional.get();
        List<Song> songsInPlaylist = playlist.getSongs();
        for (Song song : songsInPlaylist) {
            userService.removeSongFromPlaylist(playlistId, song.getId());
        }
        playlistService.deletePlaylist(playlistId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
