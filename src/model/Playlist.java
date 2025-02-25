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
        ArrayList<Song> songs = new ArrayList<>();
        for (Song song : this.songs) {
            songs.add(song.copy());
        }
        return songs;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public Playlist copy() {
        Playlist playlist = new Playlist(this.playlistName);
        for (Song song : this.songs) {
            playlist.addSong(song.copy());
        }
        return playlist;
    }


}
