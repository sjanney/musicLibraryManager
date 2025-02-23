package model;

import java.util.Objects;

public class Song {
    private String songName;
    private String artist;
    private String albumTitle;
    private int rating;
    private boolean isFavorite;

    public Song(String songName, String artist, String albumTitle) {
        this.songName = songName;
        this.artist = artist;
        this.albumTitle = albumTitle;
        this.rating = 0;
        this.isFavorite = false;
    }


    public String getSongName() {
        return songName;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }


    public int getRating() {
        return rating;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        }
    }

    public void setFavorite(boolean favorite) {
        this.isFavorite = favorite;
    }
}