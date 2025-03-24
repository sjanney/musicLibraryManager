package model;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

public class songTests {
    @Test
    public void initalTest() {
        Song test_song = new Song("title", "artist", "album", "test");
        assertNotNull(test_song);
    }

    @Test
    public void copy_album() {
        Song test_song = new Song("title", "artist", "album","test");
        Song copy_song = test_song;
        assertEquals(test_song, copy_song);
        Song deep_copy = test_song.copy();
        assertNotEquals(test_song, deep_copy);
    }

    @Test
    public void getTitle() {
        String title = "title";
        Song test_song = new Song("title", "artist", "album","test");
        assertTrue(title.equals(test_song.getSongName()));
    }

    @Test
    public void getArtist() {
        String artist = "artist";
        Song test_song = new Song("title", "artist", "album","test");
        assertTrue(artist.equals(test_song.getArtist()));
    }

    @Test
    public void getAlbum() {
        String album = "album";
        Song test_song = new Song("title", "artist", "album","test");
        assertTrue(album.equals(test_song.getAlbumTitle()));
    }

    @Test
    public void getRating() {
        Rating rating = Rating.None;
        Song test_song = new Song("title", "artist", "album","test");
        assertTrue(rating.equals(test_song.getRating()));
        test_song.setRating(2);
        rating = Rating.TWO;
        assertEquals(rating, test_song.getRating());
        //Testing invalid rating
        test_song.setRating(999);
        assertEquals(Rating.None, test_song.getRating());

        test_song.setRating(-3);
        assertEquals(Rating.None, test_song.getRating());
    }

    @Test
    public void getFavorite() {
        Favorite favorite = Favorite.Unfavorited;
        Song test_song = new Song("title", "artist", "album","test");
        assertFalse(test_song.isFavorite());
        test_song.setFavorite(true);
        assertTrue(test_song.isFavorite());
    }

    @Test
    public void testAllRating() {
        Song test_song = new Song("title", "artist", "album","test");
        Rating[] ratings = {Rating.None, Rating.ONE, Rating.TWO, Rating.THREE, Rating.FOUR, Rating.FIVE};
        for (int i = 0 ; i < 6; i++){
            test_song.setRating(i);
            assertEquals(test_song.getRating(), ratings[i]);
        }
    }

    @Test
    public void testGetters() {
        Song test_song = new Song("title", "artist", "album","test");
        assertEquals("title", test_song.getSongName());
        assertEquals("artist", test_song.getArtist());
        assertEquals("album", test_song.getAlbumTitle());
        assertEquals(Rating.None, test_song.getRating());
        assertFalse(test_song.isFavorite());
        test_song.setFavorite(true);
        assertTrue(test_song.isFavorite());
    }

    @Test
    public void printFavorite() {
        Song test_song = new Song("title", "artist", "album","test");
        test_song.setFavorite(true);
        test_song.setRating(5);
        System.out.println(test_song.favoriteToString());
        System.out.println(test_song.ratingToString());
        System.out.println(test_song.getRating());
    }

    @Test
    public void playCountTest(){
        Song test_song = new Song("title", "artist", "album","test");
        test_song.addPlayCount();
        assertEquals(1, test_song.getPlayCount());
        test_song.addPlayCount();
        assertEquals(2, test_song.getPlayCount());
        test_song.addPlayCount();
        assertEquals(3, test_song.getPlayCount());
        test_song.addPlayCount();
        assertEquals(4, test_song.getPlayCount());
        test_song.addPlayCount();
        assertEquals(5, test_song.getPlayCount());
    }

    @Test
    public void GenreTest(){
        Song test_song = new Song("title", "artist", "album","ROCK");
        assertEquals("ROCK", test_song.getGenre());
        test_song = new Song("title", "artist", "album", "POP");
        assertEquals("POP", test_song.getGenre());
    }
}
