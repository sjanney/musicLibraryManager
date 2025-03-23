package model.tests;
import model.infoDatabase;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;


public class infoDatabaseTest {
    @Test
    public void initalTest() throws FileNotFoundException {
        infoDatabase info = new infoDatabase();
        assertNotNull(info);
        info.loadDatabase();
        assertNotNull(info.getAlbums());
        assertNotNull(info.getSongs());
    }
    @Test
    public void loadTest() throws FileNotFoundException {
        infoDatabase info = new infoDatabase();
        info.loadDatabase();
    }

    @Test
    public void getAlubumSongsTest() throws FileNotFoundException {
        infoDatabase info = new infoDatabase();
        info.loadDatabase();
        String[] test = info.getAlbumSongs("19");
        assertNotNull(test);
    }

    @Test
    public void getSongsTest() throws FileNotFoundException {
        infoDatabase info = new infoDatabase();
        info.loadDatabase();
        info.markAlbumInLibrary("19");
        assertTrue(info.isAlbumInLibrary("19"));
    }

    @Test
    public void getRelatedAlubms() throws FileNotFoundException {
        infoDatabase info = new infoDatabase();
        info.loadDatabase();

        info.markAlbumInLibrary("19");
    }


}
