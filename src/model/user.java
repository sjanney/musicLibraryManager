package model;

public class user {
    String username;
    musicStore userStoreHistory;
    userLibrary userLibrary;

    public user(String username) {
        this.username = username;
        this.userStoreHistory = new musicStore();
        this.userLibrary = new userLibrary();
    }

    musicStore getUserStoreHistory() {
        return userStoreHistory;
    }

    userLibrary getUserLibrary() {
        return userLibrary;
    }

    String getUsername() {
        return username;
    }
}
