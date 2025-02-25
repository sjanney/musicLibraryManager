// makes a class that acts like a music playlist 
package model;

import java.util.ArrayList;
import java.util.Collection;

public class Playlist {
    private final String playlistName;
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

    public void removeSong(String songName, String artist) {
        songs.removeIf(song ->
                song.getSongName().equalsIgnoreCase(songName) &&
                        song.getArtist().equalsIgnoreCase(artist)
        );
    }

// something here that plays the current song or something that selects the current song

    public void skipToNextSong() {
        if (!songs.isEmpty()) {
            currentSongIndex = (currentSongIndex + 1) % songs.size();
        }
    }

    public String getPlaylistName() {
        // returns the name of the playlist
        return playlistName;
    }

    public Collection<Object> getSongs() {
        // returns the list of all songs in teh playlist
    }

    public int getCurrentSongIndex() {
        // returns where the song is in the playlist similar to the way it works in the album class
    }
}