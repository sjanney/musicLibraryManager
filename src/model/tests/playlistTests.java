package model.tests;

import model.Playlist;
import model.Song;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class playlistTests {

    @Test
    public void initalTest() {
        Playlist new_playlist = new Playlist("myPlaylist");
        Song new_album = new Song("title", "artist", "album","test");
        new_playlist.addSong(new_album);
        assertNotNull(new_playlist.getSongs());
    }

    @Test
    public void getSongTest() {
        Playlist new_playlist = new Playlist("myPlaylist");
        Song new_album = new Song("title", "artist", "album","test");
        new_playlist.addSong(new_album);
        assertNotNull(new_playlist.getSongs());
    }

    @Test
    public void getAlbumTest() {
        Playlist new_playlist = new Playlist("myPlaylist");
        assertNotNull(new_playlist.getPlaylistName());
    }

    @Test
    public void playlistCopyTest() {
        Playlist new_playlist = new Playlist("myPlaylist");
        Song new_song = new Song("title", "artist", "album","test");
        new_playlist.addSong(new_song);
        Playlist test_playlist = new_playlist;
        assertEquals(test_playlist,new_playlist);
        test_playlist = new_playlist.copy();
        assertNotEquals(test_playlist,new_playlist);
    }

    @Test public void removeSongTest() {
        Playlist new_playlist = new Playlist("myPlaylist");
        Song new_song = new Song("title", "artist", "album","test");
        new_playlist.addSong(new_song);
        assertNotNull(new_playlist.getSongs());
        new_playlist.removeSong(new_song);
        assertTrue(new_playlist.getSongs().isEmpty());
    }
    @Test
    public void addSongTest() {
        Playlist new_playlist = new Playlist("myPlaylist");
        Song new_song = new Song("title", "artist", "album","test");
        new_playlist.addSong(new_song);
        assertNotNull(new_playlist.getSongs());
        new_playlist.addSong(new_song);
        assertFalse(new_playlist.getSongs().isEmpty());
    }

    @Test
    public void shuffleSongsTest() {
        Playlist new_playlist = new Playlist("myPlaylist");

        Song song_1 = new Song("title1", "artist1", "album1","test1");
        Song song_2 = new Song("title2", "artist2", "album2","test2");
        Song song_3 = new Song("title3", "artist3", "album3","test3");

        new_playlist.addSong(song_1);
        new_playlist.addSong(song_2);
        new_playlist.addSong(song_3);

        ArrayList<Song> originalOrder = new_playlist.getSongs();
        Playlist shuffledPlaylist = new_playlist.copy();
        shuffledPlaylist.shuffleSongs();
        ArrayList<Song> shuffledOrder = shuffledPlaylist.getSongs();
        assertNotEquals(originalOrder,shuffledOrder);


    }
}
