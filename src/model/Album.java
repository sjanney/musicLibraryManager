package model;

import java.util.ArrayList;

// A class that saves the songs in the album in order and allows a user to add and remove songs from that album
public class Album {
    private String title;
    private String artist;
    private String albumTitle;
    private int rating;
    private boolean isFavorite;
    private final int year;
    private ArrayList<Song> track_list;

    public Album(String title, String artist,int year) {
        // We create our Album with
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.track_list = new ArrayList<Song>();
    }

    public void addTracks(ArrayList<String> song_data) {
        // We loop over all the given tracklists that we have
        for (int i = 0; i < song_data.size(); i++) {
            String song_name = song_data.get(i);
            String artist_name = this.artist;
            String album_title = this.albumTitle;
            Song curr_song = new Song(song_name,artist_name,album_title);
            this.track_list.add(curr_song);
        }
    }

    public void showTracks() {
        for (int i = 0; i < this.track_list.size(); i++) {
            Song curr_song = this.track_list.get(i);
            System.out.println(curr_song);
        }
    }

    public ArrayList<Song> getTracks() {
        return new ArrayList<Song>(this.track_list);
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }


}