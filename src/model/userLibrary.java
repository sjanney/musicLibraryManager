package model;
import java.util.ArrayList;
import java.util.Collections;

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

    public ArrayList<Song> searchSongByTitle(String title) {
        ArrayList<Song> searchResults = new ArrayList<>();
        for (Song song : user_songs) {
            if (title.equals(song.getSongName())) {
                searchResults.add(song);
            }
        }
        return searchResults;
    }

    public ArrayList<Song> searchSongByArtist(String artist) {
        ArrayList<Song> searchResults = new ArrayList<>();
        for (Song song : user_songs) {
            if (artist.equals(song.getArtist())) {
                searchResults.add(song.copy());
            }
        }
        return searchResults;
    }

    public ArrayList<Album> searchAlbumByTitle(String title) {
        ArrayList<Album> searchResults = new ArrayList<>();
        for (Album album : user_albums) {
            if (title.equals(album.getTitle())) {
                searchResults.add(album.copy());
            }
        }
        return searchResults;
    }

    public ArrayList<Song> getUnprotectedSongs() {
        // Special Method that sends reference to list, only used in special circumstances
        return this.user_songs;
    }

    public ArrayList<Album> searchAlbumByArtist(String artist) {
        ArrayList<Album> searchResults = new ArrayList<>();
        for (Album album : user_albums) {
            if (artist.equals(album.getArtist())) {
                searchResults.add(album.copy());
            }
        }
        return searchResults;
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

    public void sortedSongs(String type) {
        // We search for songs based on their sorted order and specific types

        // We first create a deep copy of the songs
        ArrayList<Song> sortedSongs = new ArrayList<>();
        for (int i = 0; i < user_songs.size(); i++) {
            sortedSongs.add(user_songs.get(i));
        }

        // We then define our specific sorting type
        if (type.equals("songTitle")) {
            // We sort by songs
            String[] titles = new String[sortedSongs.size()];

        }
        else if (type.equals("artistt")) {
            // We sort by the artist
        }
        else {
            // We sort by given ratings
        }
    }

    public void removeSong(Song song) {
        // Simply removes song from user's library
        user_songs.remove(song);
    }

    public void shuffleSongs() {
        // Automatically shuffles the songs in the
        Collections.shuffle(user_songs);
    }
}
