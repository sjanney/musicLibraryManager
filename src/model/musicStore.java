package model;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class musicStore {
    // This class is where we implement all the data parsing within data added within our application

    /*
     * class musicStore(): This class contains the main storefront of our music library application, here is where we
     * deal with all the backend logic and storage of possible songs
     *
     * Attributes:
     *  album_stock: This is all the current stock of albums that we have on our storefront
     *  song_stock: This is all the avalible stock of songs that we have on our storefront
     *  avalible_artists: This is all the artists that we currently carry within our storefront
     *
     *
     * Methods:
     *  getAlbums: This simply returns all of our current albums that we have within stock
     *  getSongs: This returns all the current albums that we have within stock
     *  loadInventory: This method gathers all the songs within our database and loads them into stock
     *
     */
    private ArrayList<Album> album_stock;
    private ArrayList<Song> song_stock;
    private HashMap<String, ArrayList<Object>> avalible_artists;

    public musicStore() {
        // We create our "stock" of music application
        this.album_stock = new ArrayList<>();
        this.song_stock = new ArrayList<>();
        this.avalible_artists = new HashMap<String, ArrayList<Object>>();
    }

    public ArrayList<Album> getAlbums() {
        // This returns all the current albums that we have within our inventory
        return new ArrayList<>(album_stock);
    }

    public ArrayList<Song> getSongs() {
        // Returns all the current songs that we have within our inventory
        return new ArrayList<>(song_stock);
    }

    public static void loadInventory() throws FileNotFoundException {
        // First we have to load all the possible files that we have into our storefront

        // We create a new directory and load all the possible song files
        File database = new File("albums/");
        File[] data_files = database.listFiles();

        // Check if the directory exists and contains files
        if (data_files == null) {
            System.err.println("The directory 'albums/' does not exist or is empty.");
            return;
        }

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
            p.showData();
        }
    }

    }
