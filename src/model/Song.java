package model;
import java.util.Objects;

/*
 * class Song(String title, String artist, String albumTitle): This class represents a song object
 *
 * Attributes:
 *      - String songName: Name of the current song name
 *      - String artist: Holds the artist name
 *      - String albumTitle: Holds the name of the album the song is located
 *      - Rating rating: Holds the current rating of the song
 *      - Favorite isFavorite: Shows if song is favorite or not
 *
 * Methods:
 *      - getSongName(): Returns the name of the song object
 *      - getArtist(): Returns the name of the artist of the song
 *      - getAlbumTitle(): Returns the name of the album the song is apart of
 *      - getRating(): Returns the specific rating of the song
 *      - isFavorite(): Returns if the song is a favoirte or not
 *      - setRating(): Sets rating for specific song
 *      - setFavorite(): Sets song to favoirte
 *
 */

public class Song {
    private final String songName;
    private final String artist;
    private final String albumTitle;
    private Rating rating;
    private Favorite isFavorite;

    public Song(String songName, String artist, String albumTitle) {
        this.songName = songName;
        this.artist = artist;
        this.albumTitle = albumTitle;
        this.rating = Rating.None;
        this.isFavorite = Favorite.Unfavorited;
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


    public Rating getRating() {
        return this.rating;
    }

    public boolean isFavorite() {
        if (this.isFavorite == Favorite.Favorited) {
            return true;
        }
        return false;
    }

    public void setRating(int rating) {
        if (rating == 1) {
            this.rating = Rating.ONE;
        }
        else if (rating == 2) {
            this.rating = Rating.TWO;
        }
        else if (rating == 3) {
            this.rating = Rating.THREE;
        }
        else if (rating == 4) {
            this.rating = Rating.FOUR;
        }
        else if (rating == 5) {
            this.rating = Rating.FIVE;
        }
        else {
            System.out.println("Invalid rating value: " + rating);
            this.rating = Rating.None;
        }
    }

    public void setFavorite(boolean favorite) {
        this.isFavorite = Favorite.Favorited;
    }

    public Song copy() {
        return new Song(this.songName, this.artist, this.albumTitle);
    }

}