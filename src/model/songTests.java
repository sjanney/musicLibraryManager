package model;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

public class songTests {
    @Test
    public void initalTest() {
        Song test_song = new Song("title", "artist", "album");
        assertNotNull(test_song);
    }

    @Test
    public void copy_album() {
        Song test_song = new Song("title", "artist", "album");
        Song copy_song = test_song;
        assertEquals(test_song, copy_song);
        Song deep_copy = test_song.copy();
        assertNotEquals(test_song, deep_copy);
    }

    @Test
    public void getTitle() {
        String title = "title";
        Song test_song = new Song("title", "artist", "album");
        assertTrue(title.equals(test_song.getSongName()));
    }

    @Test
    public void getArtist() {
        String artist = "artist";
        Song test_song = new Song("title", "artist", "album");
        assertTrue(artist.equals(test_song.getArtist()));
    }

    @Test
    public void getAlbum() {
        String album = "album";
        Song test_song = new Song("title", "artist", "album");
        assertTrue(album.equals(test_song.getAlbumTitle()));
    }
}
