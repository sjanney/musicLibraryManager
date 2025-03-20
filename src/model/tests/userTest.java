package model.tests;

import model.user;
import org.junit.*;

import static org.junit.Assert.assertNotNull;

public class userTest {

    @Test
    public void userTest() {
        user testUser = new user("admin");
        assertNotNull(testUser.getUserLibrary());
        assertNotNull(testUser.getUserStore());
        assertNotNull(testUser.getUsername());
    }
}
