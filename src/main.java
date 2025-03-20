import model.*;
import model.tests.userApplicationData;
import view.*;
import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        // First, we start the login page and data
        loginPage mainPage = new loginPage();
        userApplicationData userAssets = new userApplicationData();
        user userData;
        boolean running = true;
        // We officailly start our instance
        while (running) {
            // WE check if the user is able to log in or not
            String username = mainPage.startApplication();
            // If sucessful
            if (username.equals("STOP")) {
                running = false;
            }
            if (username != null && running) {
                // We gather the user data
                if (userAssets.userExists(username)) {
                    userData = userAssets.getUser(username);
                }
                else {
                    userAssets.addNewUserAssets(username);
                    userData = userAssets.getUser(username);
                }
                // We extract the assets
                musicStore store = userData.getUserStore();
                userLibrary lib = userData.getUserLibrary();
                mainUI instance = new mainUI(store,lib);
                instance.startInstance();
            }
        }
    }

}
