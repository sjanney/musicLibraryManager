package model;

import java.io.FileNotFoundException;

public class user {
    String username;
    musicStore userStoreHistory;
    model.userLibrary userLibrary;

    public user(String username) throws FileNotFoundException {
        this.username = username;
        this.userStoreHistory = new musicStore();
        this.userLibrary = new userLibrary();
    }

    public musicStore getUserStore() {
        return this.userStoreHistory;
    }

    public userLibrary getUserLibrary() {
        return this.userLibrary;
    }

    public String getUsername() {
        return this.username;
    }
}
