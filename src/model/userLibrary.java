package model;

import java.io.FileNotFoundException;
import java.util.*;

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
    private musicPlayer musicPlayer;
    private HashMap<String,ArrayList<Song>> userGenrePlaylist;

    public userLibrary() throws FileNotFoundException {
        // We create each of the users albums,songs, and playlists lists
        this.user_albums = new ArrayList<>();
        this.user_songs = new ArrayList<>();
        this.user_playlists = new ArrayList<>();
        this.informationDatabase = new infoDatabase();
        this.informationDatabase.loadDatabase();
        this.musicPlayer = new musicPlayer();
        // Create automatic playlists
        Playlist favoriteSongs = new Playlist("Favorite Songs");
        Playlist topRatedSongs = new Playlist("Top Rated Songs");
        user_playlists.add(favoriteSongs);
        user_playlists.add(topRatedSongs);
        userGenrePlaylist = new HashMap<>();
    }

    public void updateUserCuratedPlaylist() {
        // First we delete all of the previous playlists within the user's library
        for (int i = user_playlists.size() - 1; i >= 0; i--) {
            Playlist playlist = user_playlists.get(i);
            if (playlist.getTitle().equals("Favorite Songs") || playlist.getTitle().equals("Top Rated Songs")) {
                user_playlists.remove(i);
            }
        }
        // We then search for the songs that fit the automatic playlists
        ArrayList<Song> topRatedSongs = new ArrayList<>();
        ArrayList<Song> favoriteSongs = new ArrayList<>();
        for (int i = 0; user_songs.size() > i; i++) {
            Song curr_song = user_songs.get(i);
            if (curr_song.getRating() == Rating.FIVE || curr_song.getRating() == Rating.FOUR || curr_song.favoriteToString().equals("Favorited")) {
                favoriteSongs.add(curr_song);
            }
            if (curr_song.getRating() == Rating.FIVE) {
                topRatedSongs.add(curr_song);
            }
        }
        // We then create the new playlists and add them back
        Playlist favoriteSongsPlaylist = new Playlist("Favorite Songs");
        Playlist topRatedSongsPlaylist = new Playlist("Top Rated Songs");
        for (int i = 0; favoriteSongs.size() > i; i++) {
            favoriteSongsPlaylist.addSong(favoriteSongs.get(i));
        }
        for (int i = 0; topRatedSongs.size() > i; i++) {
            topRatedSongsPlaylist.addSong(topRatedSongs.get(i));
        }
        user_playlists.add(favoriteSongsPlaylist);
        user_playlists.add(topRatedSongsPlaylist);
    }

    public void playSong(Song song) {
        this.musicPlayer.playSong(song);
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

    public void updateAutomaticPlaylist() {
        ArrayList<Song> recentSongs = this.musicPlayer.getRecentlyPlayedSongs();
        ArrayList<Song> frequentSongs = this.musicPlayer.getMostFrequentlyPlayedSongs();

        // We first remove the previously created playlists (we move backwards to guarentee no index errors)
        for (int i = user_playlists.size() - 1; i >= 0; i--) {
            Playlist playlist = user_playlists.get(i);
            if (playlist.getTitle().equals("Recent Songs") || playlist.getTitle().equals("Frequent Songs")) {
                user_playlists.remove(i);
            }
        }

        // Add updated playlists
        Playlist frequentPlaylist = new Playlist("Frequent Songs");
        Playlist recentPlaylist = new Playlist("Recent Songs");

        for (Song song : recentSongs) {
            recentPlaylist.addSong(song);
        }
        for (Song song : frequentSongs) {
            frequentPlaylist.addSong(song);
        }

        user_playlists.add(frequentPlaylist);
        user_playlists.add(recentPlaylist);
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

    public void updateGenrePlaylists() {
        // First we remove all genre playlists
        for (int i = user_playlists.size() - 1; i >= 0; i--) {
            Playlist playlist = user_playlists.get(i);
            if (userGenrePlaylist.containsKey(playlist.getTitle())) {
                user_playlists.remove(i);
            }
        }

        // We create a new playlist if they have more than 10 songs
        for (Map.Entry<String, ArrayList<Song>> entry : userGenrePlaylist.entrySet()) {
            String genre = entry.getKey();
            ArrayList<Song> songs = entry.getValue();
            if (songs.size() >= 10) {
                Playlist playlist = new Playlist(genre);
                for (Song song : songs) {
                    playlist.addSong(song);
                }

                this.user_playlists.add(playlist);
            }
        }
    }

    public void addAlbum(Album album) {
        Scanner scanner = new Scanner(System.in);
        this.informationDatabase.markAlbumInLibrary(album.getTitle());
        user_albums.add(album);
        // We ask if you want to add the songs to your library as well
        System.out.println("Do you want to add all the songs to your album too?: (YES/NO)");
        String choice = scanner.nextLine();
        if (choice.equals("YES")) {
            for (Song song : album.getTracks()) {
                user_songs.add(song);
                // Add to genreplaylists
                if (userGenrePlaylist.containsKey(song.getGenre())) {
                    userGenrePlaylist.get(song.getGenre()).add(song);
                }
                else {
                    String genre = song.getGenre();
                    ArrayList<Song> songs = new ArrayList<>();
                    songs.add(song);
                    userGenrePlaylist.put(genre, songs);
                }
            }
        }
    }

    public void addSong(Song song) {
        System.out.println(song.getGenre());
        user_songs.add(song);
        // We add to our hash in case
        if (userGenrePlaylist.containsKey(song.getGenre())) {
            userGenrePlaylist.get(song.getGenre()).add(song);
        }
        if (!userGenrePlaylist.containsKey(song.getGenre())) {
            ArrayList<Song> new_songs = new ArrayList<>();
            new_songs.add(song);
            userGenrePlaylist.put(song.getGenre(),new_songs);
        }
    }

    public void deletePlaylist(String playlistName) {
        for (int i = 0; i < user_playlists.size(); i++) {
            if (user_playlists.get(i).getPlaylistName().equals(playlistName)) {
                user_playlists.remove(i);
            }
        }
    }

    public void addPlaylist(Playlist playlist) {
        user_playlists.add(playlist);
    }

    public void insertionSort(Song[] songs, String[] data_types) {
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

    public ArrayList<Song> getSongsByGenre(String genre) {
        ArrayList<Song> songs = new ArrayList<>();
        for (Song song : user_songs) {
            if (song.getGenre().equals(genre)) {
                songs.add(song);
            }
        }
        return songs;
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
