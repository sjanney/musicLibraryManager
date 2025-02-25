package model;

import java.util.ArrayList;

// A class that saves the songs in the album in order and allows a user to add and remove songs from that album
public class Album {
    private String title;
    private String artist;
    private ArrayList<Song> songs;
    private int rating;
    private boolean isFavorite;

    public Album() {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
        this.rating = 0;
        this.isFavorite = false;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(String songName) {
        songs.removeIf(song -> song.getSongName().equals(songName));
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        }
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        this.isFavorite = favorite;
    }

    public int getSongCount() {
        return songs.size();
    }

    public Song getSongByPosition(int position) {
        if (position >= 0 && position < songs.size()) {
            return songs.get(position);
        }
        return null;
    }
}