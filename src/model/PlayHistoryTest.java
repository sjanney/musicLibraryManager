package model;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class PlayHistoryTest {
    private ArrayList<Song> songStock;
    private ArrayList<Album> albumStock;
    private PlayHistory playHistory;

    @Before
    public void setUp() {
        songStock = new ArrayList<>();
        albumStock = new ArrayList<>();

        for(int i = 0; i <= 20; i++) {
            Song song = new Song("Song "+ i,"Artist "+ (i % 5 + 1),"Album " + (i % 3 + 1));
            song.setGenre(i % 2 == 0 ? "ROCK" : "POP");

            for(int j = 0; j < i % 10; j++){
                song.incrementPlayCount();
            }
            songStock.add(song);
        }
        PlayHistory playHistory = new PlayHistory(songStock, albumStock);
    }

    @Test
    public void testConstructors() {
        PlayHistory history1 = new PlayHistory(songStock, albumStock);
        assertNotNull(history1);
        assertEquals(0, history1.getRecentlyPlayedList().size());

        PlayHistory history2 = new PlayHistory(songStock, albumStock);
        assertNotNull(history2);
        assertEquals(0, history2.getRecentlyPlayedList().size());
    }
    @Test
    public void testAddPlay() {
        Song song1 = songStock.get(0);
        Song song2 = songStock.get(1);

        int initialPlayCount1 = song1.getPlayCount();
        int initialPlayCount2 = song2.getPlayCount();

        playHistory.addPlay(song1);
        assertEquals(1, playHistory.getRecentlyPlayedList().size());
        assertEquals(song1, playHistory.getRecentlyPlayedList().get(0));
        assertEquals(initialPlayCount1 + 1, song1.getPlayCount());

        playHistory.addPlay(song2);
        assertEquals(2, playHistory.getRecentlyPlayedList().size());
        assertEquals(song2, playHistory.getRecentlyPlayedList().get(0));
        assertEquals(song1, playHistory.getRecentlyPlayedList().get(1));
        assertEquals(initialPlayCount2 + 1, song2.getPlayCount());

        playHistory.addPlay(song1);
        assertEquals(2, playHistory.getRecentlyPlayedList().size());
        assertEquals(song1, playHistory.getRecentlyPlayedList().get(0));
        assertEquals(song2, playHistory.getRecentlyPlayedList().get(1));
        assertEquals(initialPlayCount1 + 2, song1.getPlayCount());
    }
    @Test
    public void testRecentlyPlayedListLimit(){
        for(int i = 0; i < 20; i++){
            playHistory.addPlay(songStock.get(i % songStock.size()));
        }
        assertTrue(playHistory.getRecentlyPlayedList().size() <= 10);

        for(int i = songStock.size() - 1; i >= 0; i--){
            playHistory.addPlay(songStock.get(i));
        }

        ArrayList<Song> recentlyPlayed = playHistory.getRecentlyPlayedList();
        for(int i = 0; i < recentlyPlayed.size(); i++){
            assertEquals(songStock.get(i), recentlyPlayed.get(songStock.size() - 1 - i));
        }
    }

    @Test
    public void testGetMostPlayedPlaylist() {

    }

    @Test
    public void testEmptyMostPlayedPlaylist(){

    }

}
