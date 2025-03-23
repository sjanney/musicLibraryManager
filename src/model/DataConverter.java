package model;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataConverter {
    // This class manipulates the parsed data and creates them into their speciifc classes, making it easier to

    /*
     * class DataConverter(Parser parser): This class converts all parsed data to their respective objects
     *
     * Attributes:
     *      - albums: This is a list of album objects
     *      - parser: This is the current parser that currently holds all the given data
     *
     * Methods:
     *      - convertData(): This coverts all the parser data to specific objects, like songs and Albums
     *      - sendData(): This sends all the data that was organized and parsed (deep copies)
     *      - showAlbums(): This function prints and shows all the current albums within the parser
     *
     */

    // Attributes
    private ArrayList<Album> albums;
    private Parser parser;

    public DataConverter(Parser parser) {
        this.albums = new ArrayList<>();
        this.parser = parser;
    }

    public void convertData() {
        // This functions converts all the data that we collected from the parser into album objects

        // WE first collect all the data from the arser
        ArrayList<ArrayList<ArrayList<String>>> file_data = this.parser.sendData();


        // Parse through each file and create
        for (int i = 0; i < file_data.size(); i++) {
            // Defining main file data
            ArrayList<ArrayList<String>> curr_file = file_data.get(i);

            // Seperating the header and main song data
            ArrayList<String> header = curr_file.get(0);
            ArrayList<String> data = curr_file.get(1);

            //Gathering all important names within fields
            String album_name = header.get(0);
            String artist_name = header.get(1);
            String year = header.get(3);
            String genre = header.get(2);

            // Debugging information, to make sure everything is working well
            /*System.out.println("album_name: " + album_name);
            System.out.println("artist_name: " + artist_name);
            System.out.println("occupation: " + occupation);
            System.out.println("year: " + year);
            System.out.println("songs: "); */

            // We first create our album, then add the songs to be
            int new_year = Integer.parseInt(year);
            Album curr_album = new Album(album_name,artist_name,new_year,genre);
            curr_album.addTracks(data);
            this.albums.add(curr_album);
        }
    }

    public ArrayList<Album> sendData() {
        // Here we send all the data our that we currently parsed

        // We create a deep copy of all the albums within our application
        ArrayList<Album> new_albums = new ArrayList<>();
        for (int i = 0; i < this.albums.size(); i++) {
            // Add a new copy of the song
            new_albums.add(this.albums.get(i).copy());
        }
        // Return the deep copy of all the albums
        return new_albums;
    }

    public void showAlbums() {
        // Here we implement the logic that prints each album and num of songs
        for (int i = 0; i < this.albums.size(); i++) {
            System.out.println("Album Name: " + this.albums.get(i).toString());
            System.out.println("Songs: " + this.albums.get(i).getTracks().size());
        }
    }


}
