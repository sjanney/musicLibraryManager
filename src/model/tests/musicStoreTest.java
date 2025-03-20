package model.tests;
import model.Album;
import model.Song;
import model.musicStore;
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
        ArrayList<Album> test_album = m.searchAlbum(false,true,null,"Old Ideas");
        assertNotNull(test_album);
        ArrayList<Album> test_album2 = m.searchAlbum(true,false,"Leonard Cohen",null);
        assertNotNull(test_album2);
    }

    @Test public void searchSongTitleTest() throws FileNotFoundException {
        musicStore m = new musicStore();
        m.loadInventory();
        ArrayList<Song> test_song = m.searchSongByTitle("Fire");
        assertNotNull(test_song);
    }


    @Test public void searchSongList() throws FileNotFoundException {
        musicStore m = new musicStore();
        m.loadInventory();
        ArrayList<Song> test_songs = m.searchSong(true,false,"Adele",null);
        assertNotNull(test_songs);
        for (Song test_song : test_songs) {
            System.out.println(test_song.getSongName());
        }
        assertNotNull(test_songs);
    }

    @Test public void getAlbumLibrary() throws FileNotFoundException {
        musicStore m = new musicStore();
        m.loadInventory();
        assertNotNull(m.albumInventory());
    }

    @Test public void sellTest() throws FileNotFoundException {
        musicStore m = new musicStore();
        m.loadInventory();
        ArrayList<Song> test_song = m.searchSong(true, false, "Adele", null);
        m.sellSong(test_song.get(0));
        ArrayList<Song> test_song2 = m.searchSongByTitle(test_song.get(0).getSongName());
        assertTrue(test_song2.isEmpty());

        // Selling Album
        ArrayList<Album> test_album = m.searchAlbum(true,false,"Adele",null);
        m.sellAlbum(test_album.get(0));
        ArrayList<Album> test_album2 = m.searchAlbum(false,true,null,test_album.get(0).getTitle());
        assertTrue(test_album2.isEmpty());

    }


}
