package model.tests;
import model.Album;
import model.Song;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
public class albumTests {
    // Current tests for our album class
    // NOTE* Coverage shows 83%, yet all code seems to be covered after calculating by hand

    @Test
    public void initalTest() {
        Album test_album = new Album("title","artist",2025,"test");
        assertNotNull(test_album);
    }

    @Test
    public void addTracksTest() {
        Album test_album = new Album("title","artist",2025,"test");
        ArrayList<Song> song_stock = new ArrayList<>();
        ArrayList<String> test_song_title = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            test_song_title.add("song_"+i);
        }
        test_album.addTracks(test_song_title);
        assertNotNull(test_album.getTracks());
        assertEquals(test_album.getTracks().size(), test_song_title.size());
    }

    @Test
    public void testShowTracks() {
        Album test_album = new Album("title","artist",2025,"test");
        ArrayList<Song> song_stock = new ArrayList<>();
        ArrayList<String> test_song_title = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            test_song_title.add("song_"+i);
        }
        test_album.addTracks(test_song_title);
        test_album.showTracks();
    }


    @Test
    public void testGetterMethods() {
        Album test_album = new Album("title","artist",2025,"test");
        assertEquals(test_album.getTitle(), "title");
        assertEquals(test_album.getArtist(), "artist");
        assertEquals(test_album.getYear(), 2025);

    }

    @Test
    public void copyTestNoTracks() {
        Album test_album = new Album("title","artist",2025,"test");
        Album new_album = test_album;
        assertEquals(test_album, new_album);
        new_album = test_album.copy();
        assertNotEquals(test_album, new_album);
    }

    @Test
    public void copyTestTracks() {
        Album test_album = new Album("title","artist",2025,"test");
        ArrayList<String> song_list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            song_list.add("song" + i);
        }
        test_album.addTracks(song_list);
        Album new_album = test_album;
        assertEquals(test_album, new_album);
        new_album = test_album.copy();
        assertNotEquals(test_album, new_album);
    }

    @Test
    public void setFavoriteTest() {
        Album test_album = new Album("title","artist",2025,"apple");
        System.out.println(test_album.getGenre());
        System.out.println(test_album.ratingToString());
    }
}
