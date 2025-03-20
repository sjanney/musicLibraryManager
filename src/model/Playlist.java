package model;
import java.util.ArrayList;
/*
 * class Playlist(): This class creates a playlist object that is stored within the user's library
 *
 * Attributes:
 *      - ArrayList<Song> songs: This is a list of songs that are contained within the playlist
 *      - String playlistName: This is the name of the current playlist
 *
 * Methods:
 *      - addSong(Song song): Adds song to the playlist
 *      - getSongs(): Sends out a copy of all the songs within the playlist
 *      - getPlaylistName(): Returns the name of the playlist
 *      - copy(): This creates a deep copy of the playlist object
 *      - removeSong(): This removes a current song from the playlist
 */

public class Playlist {
    private ArrayList<Song> songs;
    private String playlistName;

    public Playlist(String playlistName, ArrayList<Song> favoriteSongs) {
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
        Playlist playlist = new Playlist(this.playlistName, favoriteSongs);
        for (Song song : this.songs) {
            playlist.addSong(song.copy());
        }
        return playlist;
    }

    public String getTitle() {
        return this.playlistName;
    }

    public void removeSong(Song song) {
        this.songs.remove(song);
    }

}
