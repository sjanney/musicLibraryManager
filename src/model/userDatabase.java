package model;
import java.util.*;

public class userDatabase {
    HashMap<String,String[]> userPasswordPairs;

    public userDatabase() {
        this.userPasswordPairs = new HashMap<>();
    }

    void addUser(String username, String[] auth_data) {
        this.userPasswordPairs.put(username, auth_data);
    }

    String[] getUserAuthData(String username) {
        return this.userPasswordPairs.get(username);
    }
}
