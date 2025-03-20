package model.tests;
import model.loginPage;
import model.userDatabase;
import org.junit.Test;

import  static org.junit.Assert.*;

public class userDatabaseTest {
    @Test
    public void initializeUserDatabase() {
        // Login page implements the userDatabase
        loginPage login = new loginPage();
        login.registerUser();
        login.verifyUser();
    }
}
