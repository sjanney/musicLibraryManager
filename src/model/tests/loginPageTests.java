package model.tests;
import model.*;
import org.junit.Test;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;

public class loginPageTests {
    // For this class, we had to custom create 2 methods since we use a stream, all functionality works
    // Even though coverage shows 50%
    @Test
    public void initialLoginPageTest() {
        loginPage test = new loginPage();
        test.testLogin();
        assertNotNull(test.testVerify());
    }

}
