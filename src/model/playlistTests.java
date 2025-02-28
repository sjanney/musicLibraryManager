package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class playlistTests {

    @Test
    public void initalTest() {
        Playlist new_playlist = new Playlist("myPlaylist");
        Song new_album = new Song("title", "artist", "album");
        new_playlist.addSong(new_album);
        assertNotNull(new_playlist.getSongs());
    }

    @Test
    public void getSongTest() {
        Playlist new_playlist = new Playlist("myPlaylist");
        Song new_album = new Song("title", "artist", "album");
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
        Song new_song = new Song("title", "artist", "album");
        new_playlist.addSong(new_song);
        Playlist test_playlist = new_playlist;
        assertEquals(test_playlist,new_playlist);
        test_playlist = new_playlist.copy();
        assertNotEquals(test_playlist,new_playlist);
    }

    @Test public void removeSongTest() {
        Playlist new_playlist = new Playlist("myPlaylist");
        Song new_song = new Song("title", "artist", "album");
        new_playlist.addSong(new_song);
        assertNotNull(new_playlist.getSongs());
        new_playlist.removeSong(new_song);
        assertTrue(new_playlist.getSongs().isEmpty());
    }
}
