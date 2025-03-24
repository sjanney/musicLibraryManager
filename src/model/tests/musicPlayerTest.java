package model.tests;
import model.*;
import model.musicPlayer;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class musicPlayerTest {
    @Test
    public void initalPlayTest() {
        musicPlayer m = new musicPlayer();
        Song test = new Song("test","test","test","test");
        m.playSong(test);
        assertEquals(1,test.getPlayCount());
    }

    @Test
    public void getSongsTest() {
        musicPlayer m = new musicPlayer();
        ArrayList<Song> songs = m.getMostFrequentlyPlayedSongs();
        ArrayList<Song> songs2 = m.getRecentlyPlayedSongs();
        assertNotNull(songs);
        assertNotNull(songs2);
    }

    @Test
    public void maintainTest() {
        musicPlayer m = new musicPlayer();
        Song test = new Song("test","test","test","test");
        Song test2 = new Song("test2","test2","test2","test2");
        m.playSong(test);
        m.playSong(test2);
        assertEquals(1,test.getPlayCount());
        assertEquals(1,test2.getPlayCount());
        m.maintainSongLists();
        ArrayList<Song> songs = m.getMostFrequentlyPlayedSongs();
        ArrayList<Song> songs2 = m.getRecentlyPlayedSongs();

        for (Song song : songs) {
            System.out.println(song.getSongName());
        }
        for (Song song : songs2) {
            System.out.println(song.getSongName());
        }
    }
}
