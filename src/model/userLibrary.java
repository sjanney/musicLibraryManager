package model;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
    private infoDatabase informationDatabase;

    public userLibrary() throws FileNotFoundException {
        // We create each of the users albums,songs, and playlists lists
        this.user_albums = new ArrayList<>();
        this.user_songs = new ArrayList<>();
        this.user_playlists = new ArrayList<>();
        this.informationDatabase = new infoDatabase();
        informationDatabase.loadDatabase();
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

    private void insertionSort(Song[] songs, String[] data_types) {
        // We sort our strings, moving our songs array periodically as well
        for (int i = 1; i < data_types.length; i++) {
            String key = data_types[i];
            Song song_key = songs[i];
            int j = i - 1;
            // Here we use compareTo() to compare lexographical order
            while (j >= 0 && key.compareTo(data_types[j]) < 0 ){
                data_types[j + 1] = data_types[j];
                songs[j + 1] = songs[j];
                j--;
            }
            data_types[j + 1] = key;
            songs[j + 1] = song_key;
        }
    }

    public Song[] sortedSongs(String type) {
        //First, we gather all the songs of the specific type
        ArrayList<Song> searchResults = new ArrayList<>();
        ArrayList<String> data_types = new ArrayList<>();
        if (type.equals("title")) {
            // We gather all the songs that match the search
            for (int i = 0; i < user_songs.size(); i++) {
                    searchResults.add(user_songs.get(i));
                    data_types.add(user_songs.get(i).getSongName());
            }
        }
        else if (type.equals("artist")) {
            for (int i = 0; i < user_songs.size(); i++) {
                    searchResults.add(user_songs.get(i));
                    data_types.add(user_songs.get(i).getArtist());
            }
        }
        else {
            for (int i = 0; i < user_songs.size(); i++) {
                    searchResults.add(user_songs.get(i));
                    data_types.add(user_songs.get(i).getRating().toString());
            }
        }
        // We sort our data type array with insertion sort, moving our song list as well
        String[] string_array = new String[data_types.size()];
        Song[] song_array = new Song[data_types.size()];
        for (int i = 0; i < data_types.size(); i++) {
            string_array[i] = data_types.get(i);
            song_array[i] = user_songs.get(i);
        }
        insertionSort(song_array,string_array);
        // After this, we simply return our sorted songs based on type
        return song_array;

    }

    public boolean removeSong(String song) {
        Scanner scanner = new Scanner(System.in);
        // Simply removes song from user's library
        ArrayList<Song> searchResults = new ArrayList<>();
        for (int i = 0; i < user_songs.size(); i++) {
            if (user_songs.get(i).getSongName().equals(song)) {
                searchResults.add(user_songs.get(i));
            }
        }
        // Print all songs that match
        if (searchResults.size() > 1) {
            for (int i = 0; i < searchResults.size(); i++) {
                System.out.println(searchResults.get(i).getSongName() + ": " + searchResults.get(i).getArtist());
            }
            System.out.println("Multiple Results, which song will be removed?: ");
            int choice = scanner.nextInt();
            user_songs.remove(searchResults.get(choice - 1));
            return true;
        }
        if (searchResults.size() == 0) {
            return false;
        }
        user_songs.remove(searchResults.get(0));
        return true;

    }

    public void getSongData(Song song) {
        // We first print the album title
        System.out.println("Album Name: " + song.getAlbumTitle());
        // We gather all the songs
        String[] songs_in_album = this.informationDatabase.getRelatedAlbumSongs(song);
        for (int i = 0; i < songs_in_album.length; i++) {
            System.out.println(songs_in_album[i]);
        }
    }


    public void shuffleSongs() {
        // Automatically shuffles the songs in the
        Collections.shuffle(user_songs);
    }


}
