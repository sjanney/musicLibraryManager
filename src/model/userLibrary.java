package model;
import java.util.ArrayList;

/*
 * class userLibrary(): This class represents the user library and all their current music, playlists, and Albums
 *
 * Attributes
 *      - ArrayList<Album> user_albums: This contains all the users albums
 *      - ArrayList<Song> user_songs: This represents all of the users songs within their library
 *      - ArrayList<Playlist> user_playlists: This represents all of the user's playlists
 *
 * Methods
 *      - getUserAlbums(): Returns a list of the user's albums
 *      - getUserSongs(): Returns the user's songs
 *      - getUserPlaylists(): Get's the user's playlists
 *      - addAlbum(): Adds album to user's library
 *      - addSong(): Adds song to user's library
 *      - addPlaylist(): Adds playlist to user's library
 */

public class userLibrary {
    // Necessary Attributes
    private ArrayList<Album> user_albums;
    private ArrayList<Song> user_songs;
    private ArrayList<Playlist> user_playlists;

    public userLibrary() {
        // We create each of the users albums,songs, and playlists lists
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

    public Song searchSongByTitle(String title) {
        for (Song song : user_songs) {
            if (title.equals(song.getSongName())) {
                return song.copy();
            }
        }
        return null;
    }

    public Song searchSongByArtist(String artist) {
        for (Song song : user_songs) {
            if (artist.equals(song.getArtist())) {
                return song.copy();
            }
        }
        return null;
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
