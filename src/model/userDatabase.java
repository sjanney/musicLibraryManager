package model;
import java.util.*;

public class userDatabase {
    HashMap<String,String[]> userPasswordPairs;

    public userDatabase() {
        this.userPasswordPairs = new HashMap<>();
    }

    void addUser(String username, String[] password) {
        this.userPasswordPairs.put(username, password);
    }
}
