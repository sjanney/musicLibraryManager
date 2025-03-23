package model;
import java.util.ArrayList;




public class Album {
    // A class that saves the songs in the album in order and allows a user to add and remove songs from that album

    /*
     * class Album(): This class replcates a given Album, with a title, tracklist, and other types of attributes
     *
     * Attributes:
     *      - String title: This attribute holds the title of the album
     *      - String artist: This holds the given artist name
     *      - String albumTitle: This is the name of the given album
     *      - Rating rating: Enum that contains rating attribute
     *      - Favorite isFavorite: Enum that contains favorite status
     *      - int year: Contains the year the album was released
     *
     * Methods:
     *  aaddTracks(ArrayList<String> song_data): Adds tracks to album with titles of songs
     *  showTracks(): Shows all of the tracks withn the album
     *  getTracks(): Returns a list of all tracks within the given album, (deep copy of all elements)
     *  getYear(): Gets the current year of the album
     *  getTitle(): Gets title of the album
     *  getArtist(): Gets artist name of the album
     *  copy(): Create a new copy of the Album without references, for encapsulation
     *
     */

    // Created instance variables
    private String artist;
    private String albumTitle;
    private Rating rating;
    private Favorite isFavorite;
    private final int year;
    private String genre;
    private ArrayList<Song> track_list;
    // Attribute used when creating a copy of all the songs
    private  ArrayList<String> raw_data;

    public Album(String title, String artist,int year,String genre) {
        // We create our Album with these attributes
        this.albumTitle = title;
        this.artist = artist;
        this.year = year;
        this.track_list = new ArrayList<Song>();
        this.isFavorite = Favorite.Unfavorited;
        this.rating = Rating.None;
        this.genre = genre;
    }

    public void addTracks(ArrayList<String> song_data) {
        // We loop over all the given songs names and add to our tracklist
        this.raw_data = song_data;
        for (int i = 0; i < song_data.size(); i++) {
            // Gather all attributes
            String song_name = song_data.get(i);
            String artist_name = this.artist;
            String album_title = this.albumTitle;
            // Add to tracklist
            Song curr_song = new Song(song_name,artist_name,album_title,this.genre);
            this.track_list.add(curr_song);
        }
    }

    public void showTracks() {
        // Prints all the tracks within our tracklist
        for (int i = 0; i < this.track_list.size(); i++) {
            Song curr_song = this.track_list.get(i);
            System.out.println(curr_song.getSongName());
        }
    }

    public ArrayList<Song> getTracks() {
        // Sends deep copy of all tracks
        ArrayList<Song> curr_tracks = new ArrayList<Song>();
        for (int i = 0; i < this.track_list.size(); i++) {
            curr_tracks.add(this.track_list.get(i).copy());
        }
        return curr_tracks;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return albumTitle;
    }

    public String getArtist() {
        return artist;
    }

    public Album copy() {
        // We first create a new object
        Album copy_album = new Album(this.albumTitle, this.artist, this.year,this.genre);

        // We then add the rest of the fields
        copy_album.albumTitle = this.albumTitle;
        copy_album.rating = this.rating;
        copy_album.isFavorite = this.isFavorite;
        if (this.raw_data != null) {
            copy_album.addTracks(this.raw_data);
        }
        return copy_album;
    }

    public String ratingToString() {
        return this.rating.toString();
    }

    public ArrayList<String> getSongs() {
        ArrayList<String> songs = new ArrayList();
        for (int i = 0; i < this.track_list.size(); i++) {
            String curr_song = this.track_list.get(i).getSongName();
            songs.add(curr_song);
        }
        return songs;
    }

    public String getGenre() {
        return genre;
    }

    public String favoriteToString() {
        if (this.isFavorite == Favorite.Favorited) {
            return "favorite";
        }
        return "unfavorite";
    }

}