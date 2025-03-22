package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class musicStore {
    // This class is where we implement all the data parsing within data added within our application

    /*
     * class musicStore(): This class contains the main storefront of our music library application, here is where we
     * deal with all the backend logic and storage of possible songs
     *
     * Attributes:
     *  album_stock: This is all the current stock of albums that we have on our storefront
     *  - Data Structre: List of Albums
     *  song_stock: This is all the avalible stock of songs that we have on our storefront
     *   - Data Structure: Array of Songs
     *  avalible_artists: This is all the artists that we currently carry within our storefront
     *  - Data Structure: Hashmap of (String) artists that contain all their albums
     *
     *
     * Methods:
     *  getAlbums: This simply returns all of our current albums that we have within stock
     *  getSongs: This returns all the current albums that we have within stock
     *  loadInventory: This method gathers all the songs within our database and loads them into stock
     *
     */

    public ArrayList<Album> album_stock;
    public ArrayList<Song> song_stock;

    public musicStore() {
        // We create our "stock" of music application
        this.album_stock = new ArrayList<>();
        this.song_stock = new ArrayList<>();
        System.out.print("");
    }

    public ArrayList<Album> getAlbums() {
        // This returns all the current albums that we have within our inventory
        return new ArrayList<>(album_stock);
    }

    public ArrayList<Song> getSongs() {
        // Returns all the current songs that we have within our inventory
        return new ArrayList<>(song_stock);
    }

    public void loadInventory() throws FileNotFoundException {
        // First we have to load all the possible files that we have into our storefront

        // We create a new directory and load all the possible song files
        File database = new File("src/albums");
        File[] data_files = database.listFiles();


        // We create our parser object and load our files
        Parser p = new Parser();
        for (int i = 0; i < data_files.length; i++) {
            try {
                // We load the specific path of the given song file into our parser
                p.loadFile(data_files[i].getPath());
            } catch (Exception e) {
                // Handle any other unexpected exceptions
                System.err.println("Unexpected error occurred," + e.getMessage());
            }
        }

        // We run our parser
        p.parseFiles();
        if (p.parserStatus()) {
            // We use our dataConverter class to create the data into albums
            DataConverter dataConverter = new DataConverter(p);
            dataConverter.convertData();
            // After we do this, we then add this album to our storefront
            this.album_stock = dataConverter.sendData();
        }

        // After we add our songs to our stock
        for (int i = 0; i < this.album_stock.size(); i++) {
            ArrayList<Song> current_songs = this.album_stock.get(i).getTracks();
            for (int j = 0; j < current_songs.size(); j++) {
                this.song_stock.add(current_songs.get(j).copy());
            }
        }

    }

    public ArrayList<Song> searchSong(boolean byArtist, boolean byAlbum, String artist, String album) {
        // We search based on either artist name or by album name
        if (byArtist) {
            ArrayList<Song> result = new ArrayList<Song>();
            for (int i = 0; i < this.album_stock.size(); i++) {
                Album curr_album = this.album_stock.get(i);
                String curr_artist = curr_album.getArtist();
                if (artist.equals(curr_artist)) {
                    // .addAll allows us to add all the related songs to our result list without creating
                    // another for-loop
                    result.addAll(curr_album.getTracks());
                }
            }
            return result;
        }
        else if (byAlbum) {
            for (int i = 0; i < this.album_stock.size(); i++) {
                if (this.album_stock.get(i).getTitle().equals(album)) {
                    return new ArrayList<Song>(this.album_stock.get(i).getTracks());
                }
            }
        }
        return null;
    }

    public ArrayList<Album> searchAlbum(boolean byArtist,boolean byTitle, String artist, String albumTitle) {
        ArrayList<Album> search_result= new ArrayList<>();
        if (byArtist) {
            for (int i = 0; i < this.album_stock.size(); i++) {
                String curr_artist = this.album_stock.get(i).getArtist();
                if (curr_artist.equals(artist)) {
                    search_result.add(album_stock.get(i).copy());
                }
            }
        }

        else if (byTitle) {
            for (int i = 0; i < this.album_stock.size(); i++) {
                if (this.album_stock.get(i).getTitle().equals(albumTitle)) {
                    search_result.add(this.album_stock.get(i).copy());
                }
            }
        }
        return search_result;
    }

    public int albumInventory() {
        return this.album_stock.size();
    }

    public ArrayList<Song> searchSongByTitle(String title) {
        ArrayList<Song> search_results = new ArrayList<>();
        for (int i = 0; i < this.song_stock.size(); i++) {
            if (this.song_stock.get(i).getSongName().equals(title)) {
                search_results.add( this.song_stock.get(i).copy());
            }
        }
        return search_results;
    }

    public void sellSong(Song song) {
        for (int i = 0; i < this.song_stock.size(); i++) {
            if (this.song_stock.get(i).getSongName().equals(song.getSongName()) && this.song_stock.get(i).getArtist().equals(song.getArtist())) {
                this.song_stock.remove(i);
            }
        }
    }

    public void sellAlbum(Album album) {
        for (int i = 0; i < this.album_stock.size(); i++) {
            if (this.album_stock.get(i).getTitle().equals(album.getTitle()) && this.album_stock.get(i).getArtist().equals(album.getArtist())) {
                this.album_stock.remove(i);
            }
        }
    }

}
