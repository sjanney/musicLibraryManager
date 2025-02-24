package model;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class musicStoreTest {
    @Test
    public  void initalTest() throws FileNotFoundException {
        musicStore m = new musicStore();
        assertEquals(m.getAlbums(), new ArrayList<Album>());
        assertEquals(m.getSongs(),new ArrayList<Album>());
        // Adding music to inventory
        m.loadInventory();
        assertNotEquals(m.getAlbums(), new ArrayList<Album>());
        assertNotEquals(m.getSongs(),new ArrayList<Song>());
    }

    @Test
    public void searchAlbumTest() throws FileNotFoundException {
        musicStore m = new musicStore();
        m.loadInventory();
        Album test_album = m.searchAlbum(false,true,null,"Old Ideas");
        assertNotNull(test_album);
        Album test_album2 = m.searchAlbum(true,false,"Leonard Cohen",null);
        assertNotNull(test_album2);
    }

    @Test public void searchSongTitleTest() throws FileNotFoundException {
        musicStore m = new musicStore();
        m.loadInventory();
        Song test_song = m.searchSongByTitle("Fire");
        assertNotNull(test_song);
    }


    @Test public void searchSongList() throws FileNotFoundException {
        musicStore m = new musicStore();
        m.loadInventory();
        ArrayList<Song> test_songs = m.searchSong(true,false,"Adele",null);
        System.out.println(test_songs.size());
        for (Song test_song : test_songs) {
            System.out.println(test_song.getSongName());
        }
        assertNotNull(test_songs);
    }



}
