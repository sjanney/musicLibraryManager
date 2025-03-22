package model.tests;

import model.user;
import org.junit.*;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertNotNull;

public class userTest {

    @Test
    public void userTest() throws FileNotFoundException {
        user testUser = new user("admin");
        assertNotNull(testUser.getUserLibrary());
        assertNotNull(testUser.getUserStore());
        assertNotNull(testUser.getUsername());
    }
}
