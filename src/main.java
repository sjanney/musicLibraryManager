import model.*;
import view.*;
import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        musicStore store = new musicStore();
        userLibrary lib = new userLibrary();
        mainUI instance = new mainUI(store, lib);
        instance.startInstance();
    }

}
