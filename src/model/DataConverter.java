package model;
import java.util.*;

public class DataConverter {
    // This class manipulates the parsed data and creates them into their speciifc classes, making it easier to
    // be entered int the database that we have for our user
    // Convert possibly to files? May or may not use
    private ArrayList<Album> albums;
    private Parser parser;

    public DataConverter(Parser parser) {
        this.albums = new ArrayList<>();
        this.parser = parser;
    }

    public void convertData() {
        ArrayList<ArrayList<ArrayList<String>>> file_data = this.parser.sendData();
        // Parse through each file and create
        for (int i = 0; i < file_data.size(); i++) {
            // Seperating the data in each given file to be created

            // Defining main file data
            ArrayList<ArrayList<String>> curr_file = file_data.get(i);

            // Seperating the header and main song data
            ArrayList<String> header = curr_file.get(0);
            ArrayList<String> data = curr_file.get(1);

            //Gathering all important names within fields
            System.out.println(header);
            String album_name = header.get(0);
            String artist_name = header.get(1);
            String occupation = header.get(2);
            String year = header.get(3);

            // Debugging information, to make sure everything is working well
            System.out.println("album_name: " + album_name);
            System.out.println("artist_name: " + artist_name);
            System.out.println("occupation: " + occupation);
            System.out.println("year: " + year);
            System.out.println("songs: ");

            // We first create our album, then add the songs to be
            int new_year = Integer.parseInt(year);
            Album curr_album = new Album(album_name,artist_name,new_year);
            System.out.println("data: " + data);
            curr_album.addTracks(data);
            this.albums.add(curr_album);
        }
    }

    public ArrayList<Album> sendData() {
        return new ArrayList<Album>(this.albums);
    }

    public void showAlbums() {
        // Here we implement the logic that prints each album and num of songs
    }



}
