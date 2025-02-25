package model;

public class Song {
    private String songName;
    private String artist;
    private String albumTitle;
    private int rating;
    private boolean isFavorite;
    private int trackPosition;

    public Song() {
        this.songName = songName;
        this.artist = artist;
        this.albumTitle = albumTitle;
        this.trackPosition = trackPosition;
        this.rating = 0;
        this.isFavorite = false;
    }

    public Song(String songName, String artist, String albumTitle) {
        this.rating = 0;
        this.isFavorite = false;
    }

    public String getSongName() {
        return this.songName;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public int getTrackPosition() {
        return trackPosition;
    }

    public void setTrackPosition(int trackPosition) {
        if (trackPosition >= 0) {
            this.trackPosition = trackPosition;
        }
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