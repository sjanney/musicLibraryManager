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

    public void removeSong(Song song) {
        // Simply removes song from user's library
        user_songs.remove(song);
    }

    public void shuffleSongs() {
        // Automatically shuffles the songs in the
        Collections.shuffle(user_songs);
    }

    public static void main(String[] args) {
        userLibrary userLibrary = new userLibrary();
        Song test2 = new Song("test2","test2","test2");
        Song test3 = new Song("test3","test3","test3");
        Song test1 = new Song("test1","test1","test1");
        userLibrary.addSong(test1);
        userLibrary.addSong(test2);
        userLibrary.addSong(test3);
        Song[] sorted_test = userLibrary.sortedSongs("title");
        for (Song song : sorted_test) {
            System.out.println(song.getSongName());
        }
        // Testing shuffling
        System.out.println(userLibrary.user_songs);
        userLibrary.shuffleSongs();
        System.out.println(userLibrary.user_songs);

    }
}
