import model.*;
import view.*;

public class main {
    public static void main(String[] args) {
        musicStore store = new musicStore();
        userLibrary lib = new userLibrary();
        mainUI instance = new mainUI(store, lib);
        instance.startInstance();
    }
}
