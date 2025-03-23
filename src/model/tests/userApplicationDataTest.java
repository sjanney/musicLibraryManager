package model.tests;
import org.junit.*;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertNotNull;

public class userApplicationDataTest {
    @Test
    public void initalTest() throws FileNotFoundException {
        userApplicationData userApplicationData = new userApplicationData();
        userApplicationData.addNewUserAssets("user1");
        userApplicationData.addNewUserAssets("user2");
        assertNotNull(userApplicationData.getUser("user1"));
        assertNotNull(userApplicationData.getUser("user2"));
    }
}
