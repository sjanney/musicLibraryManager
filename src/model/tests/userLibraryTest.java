package model.tests;
import static org.junit.Assert.*;

import model.Album;
import model.Playlist;
import model.Song;
import model.userLibrary;
import org.junit.Test;

import java.util.ArrayList;

public class userLibraryTest {

    @Test
    public void initalTest() {
        userLibrary userLibrary = new userLibrary();
        assertNotNull(userLibrary);
    }

    @Test
    public void addAlbumTest() {
        userLibrary userLibrary = new userLibrary();
        Album new_album = new Album("title","artist",2025);
        userLibrary.addAlbum(new_album);
        assertNotNull(userLibrary.getUserAlbums());
        assertEquals(1, userLibrary.getUserAlbums().size());
    }

    @Test
    public void addSongTest() {
        userLibrary userLibrary = new userLibrary();
        Song new_song = new Song("title","artist","album");
        userLibrary.addSong(new_song);
        assertNotNull(userLibrary.getUserSongs());
        assertEquals(1, userLibrary.getUserSongs().size());
    }

    @Test
    public void addPlaylistTest() {
        userLibrary userLibrary = new userLibrary();
        Playlist new_album = new Playlist("title");
        userLibrary.addPlaylist(new_album);
        assertNotNull(userLibrary.getUserAlbums());
        assertEquals(1, userLibrary.getUserPlaylists().size());
    }

    @Test
    public void testUnprotected() {
        userLibrary userLibrary = new userLibrary();
        Song new_song = new Song("title","artist","album");
        userLibrary.addSong(new_song);
        assertNotNull(userLibrary.getUserSongs());
        ArrayList<Song> userSongs = userLibrary.getUnprotectedSongs();
        assertNotEquals(userSongs, userLibrary.getUserSongs());
    }

    @Test
    public void searchTest() {
        userLibrary userLibrary = new userLibrary();
        Song new_song = new Song("title","artist","album");
        userLibrary.addSong(new_song);
        ArrayList<Song> test_1 = userLibrary.searchSongByArtist(new_song.getArtist());
        assertNotEquals(test_1, userLibrary.getUserSongs());
        ArrayList<Album> test_2 = userLibrary.searchAlbumByArtist("Adele");
        assertNotNull(test_2);
        test_2 = userLibrary.searchAlbumByTitle("Adele");
        assertNotNull(test_2);
        ArrayList<Song> new_song2 = userLibrary.searchSongByTitle(new_song.getSongName());
        assertNotNull(new_song2.get(0));

    }
}
