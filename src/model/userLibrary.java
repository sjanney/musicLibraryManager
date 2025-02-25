package model;

import java.util.ArrayList;

public class userLibrary {
    private ArrayList<Album> user_albums;
    private ArrayList<Song> user_songs;
    private ArrayList<Playlist> user_playlists;

    public userLibrary() {
        this.user_albums = new ArrayList<>();
        this.user_songs = new ArrayList<>();
        this.user_playlists = new ArrayList<>();
    }

    public ArrayList<Album> getUserAlbums() {
        ArrayList<Album> new_albums = new ArrayList<>();
        for (Album album : user_albums) {
            new_albums.add(album.copy());
        }
        return new_albums;
    }

    public ArrayList<Song> getUserSongs() {
        ArrayList<Song> new_songs = new ArrayList<>();
        for (Song song : user_songs) {
            new_songs.add(song.copy());
        }
        return new_songs;
    }

    public ArrayList<Playlist> getUserPlaylists() {
        ArrayList<Playlist> new_playlists = new ArrayList<>();
        for (Playlist playlist : user_playlists) {
            new_playlists.add(playlist.copy());
        }
        return new_playlists;
    }

    public void addAlbum(Album album) {
        user_albums.add(album);
    }

    public void addSong(Song song) {
        user_songs.add(song);
    }

    public void addPlaylist(Playlist playlist) {
        user_playlists.add(playlist);
    }

}
