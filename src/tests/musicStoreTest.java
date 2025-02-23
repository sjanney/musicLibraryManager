package tests;

import model.musicStore;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class musicStoreTest {
    @Test
    public  void inital_testing() throws FileNotFoundException {
        musicStore m = new musicStore();
        assertNull(m.getAlbums());
        assertNull(m.getSongs());
        // Adding music to inventory
        m.loadInventory();
        assertNotNull(m.getAlbums());
    }
}
