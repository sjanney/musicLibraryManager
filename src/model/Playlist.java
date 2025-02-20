// makes a class that acts like a music playlist 
package model;

import java.util.ArrayList;

public class Playlist {
    private String playlistName;
    private ArrayList<Song> songs;
    private int currentSongIndex;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.songs = new ArrayList<>();
        this.currentSongIndex = -1;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(String songName) {
        songs.removeIf(song -> song.getSongName().equalsIgnoreCase(songName));
    }

// something here that plays the current song or something that selects the current song

    public void skipToNextSong() {
        if (!songs.isEmpty()) {
            currentSongIndex = (currentSongIndex + 1) % songs.size();
        }
    }
}