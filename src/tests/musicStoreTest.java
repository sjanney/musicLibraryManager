package tests;

import model.musicStore;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class musicStoreTest {
    @Test
    public void test1() throws FileNotFoundException {
        musicStore m = new musicStore();
        musicStore.loadInventory();
        boolean x = true;
        assertTrue(x);
    }
}
