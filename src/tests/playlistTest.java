package tests;

import model.Playlist;
import model.Song;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class playlistTest {
    private Playlist playlist;
    private Song song1;
    private Song song2;
    private Song song3;

    @Before
    public void setUp() {
        playlist = new Playlist("My Awesome Mix");
        song1 = new Song("Rolling in the Deep", "Adele", "21");
        song2 = new Song("Yellow", "Coldplay", "Parachutes");
        song3 = new Song("Hey Jude", "The Beatles", "The Beatles");
    }

    @Test
    public void testPlaylistCreation() {
        assertEquals("My Awesome Mix", playlist.getPlaylistName());
        assertEquals(0, playlist.getSongs().size());
        assertEquals(-1, playlist.getCurrentSongIndex());
    }

    @Test
    public void testAddSongs() {
        playlist.addSong(song1);
        assertEquals(1, playlist.getSongs().size());
        assertTrue(playlist.getSongs().contains(song1));

        playlist.addSong(song2);
        assertEquals(2, playlist.getSongs().size());
        assertTrue(playlist.getSongs().contains(song2));
    }

    @Test
    public void testRemoveSongs() {
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        playlist.removeSong("Yellow", "Coldplay");
        assertEquals(2, playlist.getSongs().size());
        assertFalse(playlist.getSongs().contains(song2));
    }

    @Test
    public void testSkipToNextSong() {
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        playlist.skipToNextSong();
        assertEquals(0, playlist.getCurrentSongIndex());

        playlist.skipToNextSong();
        assertEquals(1, playlist.getCurrentSongIndex());

        playlist.skipToNextSong();
        assertEquals(2, playlist.getCurrentSongIndex());

        // Test wrap-around
        playlist.skipToNextSong();
        assertEquals(0, playlist.getCurrentSongIndex());
    }

    @Test
    public void testSkipToNextSongEmptyPlaylist() {
        playlist.skipToNextSong();
        assertEquals(-1, playlist.getCurrentSongIndex());
    }

    @Test
    public void testRemoveCurrentSong() {
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.skipToNextSong();
        playlist.removeSong(song1.getSongName(), song1.getArtist());
        assertEquals(1, playlist.getSongs().size());
        assertEquals(0, playlist.getCurrentSongIndex());
    }
}
