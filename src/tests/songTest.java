// this clsss will test to make sure the song class work with the
// album and playlist class and to make sure the song class intergtates
// with the parser
package tests;

import model.Song;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class songTest {
    private Song song;
    private Song emptyConstructorSong;

    @Before
    public void setUp() {
        song = new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera");
        emptyConstructorSong = new Song();
    }

    @Test
    public void testSongConstructor() {
        assertEquals("Bohemian Rhapsody", song.getSongName());
        assertEquals("Queen", song.getArtist());
        assertEquals("A Night at the Opera", song.getAlbumTitle());
        assertEquals(0, song.getRating());
        assertFalse(song.isFavorite());
    }

    @Test
    public void testSetAndGetTrackPosition() {
        song.setTrackPosition(3);
        assertEquals(3, song.getTrackPosition());

        // Test negative track position
        song.setTrackPosition(-1);
        assertEquals(3, song.getTrackPosition());
    }

    @Test
    public void testSetAndGetRating() {
        song.setRating(4);
        assertEquals(4, song.getRating());

        // Test invalid ratings
        song.setRating(0);
        assertEquals(4, song.getRating());

        song.setRating(6);
        assertEquals(4, song.getRating());
    }

    @Test
    public void testSetAndGetFavorite() {
        assertFalse(song.isFavorite());

        song.setFavorite(true);
        assertTrue(song.isFavorite());

        song.setFavorite(false);
        assertFalse(song.isFavorite());
    }

    @Test
    public void testEmptyConstructor() {
        assertNull(emptyConstructorSong.getSongName());
        assertNull(emptyConstructorSong.getArtist());
        assertNull(emptyConstructorSong.getAlbumTitle());
        assertEquals(0, emptyConstructorSong.getRating());
        assertFalse(emptyConstructorSong.isFavorite());
    }
}
