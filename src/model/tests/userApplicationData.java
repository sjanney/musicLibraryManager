package model.tests;

import model.user;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class userApplicationData {
    HashMap<String, user> userAssestData;

    public userApplicationData() {
        this.userAssestData = new HashMap<>();
    }

    public void addNewUserAssets(String username) throws FileNotFoundException {
        this.userAssestData.put(username, new user(username));
    }

    public user getUser(String username) {
        return this.userAssestData.get(username);
    }

    public boolean userExists(String username) {
        return this.userAssestData.containsKey(username);
    }
}
