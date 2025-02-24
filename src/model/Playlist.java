package model;

import java.util.ArrayList;

public class Playlist {
    private ArrayList<Song> songs;
    private String playlistName;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getPlaylistName() {
        return playlistName;
    }


}
