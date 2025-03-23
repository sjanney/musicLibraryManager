package view;
import model.*;
import model.userLibrary;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
/*
 * class mainUI(): This is that class that shows the user the main textual elements of the user music library and store
 *
 * Attributes
 *      - multiple colors: These are colors that we use throughout the UI
 *      - musicStore store: This is the store class that we use throughout the class
 *      - userLibrary user: This is the instance of the user's library
 * Methods
 *      -
 */


public class mainUI {
    private musicStore store;
    private userLibrary user;
    private Scanner scanner;

    // These are color codes that are used within the terminal (*created with AI)
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";

    public mainUI(musicStore store, userLibrary user) {
        this.store = store;
        this.user = user;
        this.scanner = new Scanner(System.in);
    }

    public void startInstance() throws FileNotFoundException {
        // This methods create's the instance of the UI, allowing it to be ran until terminated
        this.store.loadInventory();
        boolean running = true;
        while (running != false) {
            displayMainMenu();
            int choice = getUserChoice();
            running = handleMainMenuChoice(choice);
        }
    }

    private int getUserChoice() {
        System.out.print(YELLOW + "Enter your choice: " + RESET);
        while (!scanner.hasNextInt()) {
            System.out.println(RED + "Please enter a valid number." + RESET);
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    private static void printTitle(String title) {
        // Prints the title with necessary colors (*created with AI)
        System.out.println(PURPLE + "\n=== " + title + " ===" + RESET + "\n");
    }

    private void displayMainMenu() {
        clearScreen();
        printTitle("Music Library System");

        String[] headers = {"Option", "Description"};
        String[][] data = {
                {"1", "Music Store"},
                {"2", "User Library"},
                {"3", "Create New Playlist"},
                {"4", "Set Rating"},
                {"5", "Set Favorites"},
                {"6", "Exit"}
        };
        printTable(headers, data);
    }

    private void printTable(String[] headers, String[][] data) {
        // Functions that prints out all the data in necessary tables in nice format (*created with AI)

        // Calculate column widths
        int[] columnWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            columnWidths[i] = headers[i].length();
            for (String[] row : data) {
                if (row[i].length() > columnWidths[i]) {
                    columnWidths[i] = row[i].length();
                }
            }
            // Add some padding
            columnWidths[i] += 2;
        }

        // Print header line
        printTableLine(columnWidths);

        // Print headers
        for (int i = 0; i < headers.length; i++) {
            System.out.print("| " + CYAN + padRight(headers[i], columnWidths[i]) + RESET);
        }
        System.out.println("|");

        // Print divider
        printTableLine(columnWidths);

        // Print data
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                System.out.print("| " + padRight(row[i], columnWidths[i]));
            }
            System.out.println("|");
        }

        // Print bottom line
        printTableLine(columnWidths);
    }

    private void printTableLine(int[] columnWidths) {
        // (*created with AI)
        System.out.print("+");
        for (int width : columnWidths) {
            System.out.print("-".repeat(width) + "+");
        }
        System.out.println();
    }

    private String padRight(String s, int n) {
        // (*created with AI)
        return String.format("%-" + n + "s", s);
    }

    private static void clearScreen() {
        // (*Created with AI)
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void promptEnterToContinue() {
        System.out.println(YELLOW + "\nPress Enter to continue..." + RESET);
        scanner.nextLine();
    }

    private boolean handleMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                musicStoreInterface();
                promptEnterToContinue();
                return true;
            case 2:
                userLibraryInterface();
                promptEnterToContinue();
                return true;
            case 3:
                createNewPlaylist();
                promptEnterToContinue();
                return true;
            case 4:
                setRating();
                promptEnterToContinue();
                return true;
            case 5:
                setFavorite();
                promptEnterToContinue();
                return true;
            case 6:
                System.out.println(GREEN + "Thank you for using the Music Library System!" + RESET);
                return false;
            default:
                System.out.println(RED + "Invalid choice. Please try again." + RESET);
                promptEnterToContinue();
        }
        return false;
    }

    public void setFavorite() {
        String[] headers = {"Option", "Description"};
        String[][] options = {
                {"1", "Set a Favorite for a Song"},
                {"2", "Set a Favorite for a Album"}
        };
        printTable(headers, options);
        int choice = getUserChoice();
        switch (choice) {
            case 1: // favoriting a song
                System.out.println("Enter the Title of the song: ");
                String title = scanner.nextLine();
                ArrayList<Song> songs = user.searchSongByTitle(title);
                // favorite the Song
                Song currentSong = songs.get(0);
                currentSong.setFavorite(true);
        }
    }
    private void displayMusicStoreOptions() {
        clearScreen();
        printTitle("Music Store");

        String[] headers = {"Option", "Description"};
        String[][] data = {
                {"1", "Search for a Song"},
                {"2", "Search for a Album"},
                {"3", "Buy Song to Library"},
                {"4", "Buy Album to Library"},
                {"5", "Exit"}
        };
        printTable(headers, data);


    }

    private void searchSong(String type) {
        clearScreen();

        if (type.equals("Music Store")) {
            // Display the search options table.
            String[] headers = {"Option", "Description"};
            String[][] options = {
                    {"1", "Search By Title"},
                    {"2", "Search By Artist"}
            };
            printTable(headers, options);

            int choice = getUserChoice();
            String searchTerm = "";
            ArrayList<Song> searchResults = new ArrayList<>();

            switch (choice) {
                case 1:
                    // Search by Title
                    while (searchTerm.trim().isEmpty()) {
                        System.out.print(YELLOW + "Enter Song Title: " + RESET);
                        searchTerm = scanner.nextLine();
                    }
                    searchResults = store.searchSongByTitle(searchTerm);
                    break;

                case 2:
                    // Search by Artist
                    while (searchTerm.trim().isEmpty()) {
                        System.out.print(YELLOW + "Enter Artist Name: " + RESET);
                        searchTerm = scanner.nextLine();
                    }
                    searchResults = store.searchSong(true, false,searchTerm, "");
                    break;

                default:
                    System.out.println("Invalid option selected.");
                    return;
            }

            // Check if search returned any results.
            if (searchResults.isEmpty()) {
                System.out.println("No songs found for: " + searchTerm);
                return;
            }

            // Prepare table data for displaying search results.
            String[] resultHeaders = {"Title", "Artist", "Album", "Favorite?", "Rating"};
            String[][] resultData = new String[searchResults.size()][5];

            for (int i = 0; i < searchResults.size(); i++) {
                Song currentSong = searchResults.get(i);
                resultData[i][0] = currentSong.getSongName();
                resultData[i][1] = currentSong.getArtist();
                // Assuming a getAlbum() method exists; if not, adjust as needed.
                resultData[i][2] = currentSong.getAlbumTitle();
                resultData[i][3] = currentSong.favoriteToString();
                resultData[i][4] = currentSong.ratingToString();
            }
            printTable(resultHeaders, resultData);
        } else {
            // This is for the user library

            // Display the search options table.
            String[] headers = {"Option", "Description"};
            String[][] options = {
                    {"1", "Search By Title"},
                    {"2", "Search By Artist"}
            };
            printTable(headers, options);

            int choice = getUserChoice();
            String searchTerm = "";
            ArrayList<Song> searchResults = new ArrayList<>();

            switch (choice) {
                case 1:
                    // Search by Title
                    while (searchTerm.trim().isEmpty()) {
                        System.out.print(YELLOW + "Enter Song Title: " + RESET);
                        searchTerm = scanner.nextLine();
                    }
                    searchResults = user.searchSongByTitle(searchTerm);
                    break;

                case 2:
                    // Search by Artist
                    while (searchTerm.trim().isEmpty()) {
                        System.out.print(YELLOW + "Enter Artist Name: " + RESET);
                        searchTerm = scanner.nextLine();
                    }
                    searchResults = user.searchSongByArtist(searchTerm);
                    break;

                default:
                    System.out.println("Invalid option selected.");
                    return;
            }

            // Check if search returned any results.
            if (searchResults.isEmpty()) {
                System.out.println("No songs found for: " + searchTerm);
                return;
            }

            // Prepare table data for displaying search results.
            String[] resultHeaders = {"Title", "Artist", "Album", "Favorite?", "Rating"};
            String[][] resultData = new String[searchResults.size()][5];

            for (int i = 0; i < searchResults.size(); i++) {
                Song currentSong = searchResults.get(i);
                resultData[i][0] = currentSong.getSongName();
                resultData[i][1] = currentSong.getArtist();
                // Assuming a getAlbum() method exists; if not, adjust as needed.
                resultData[i][2] = currentSong.getAlbumTitle();
                resultData[i][3] = currentSong.favoriteToString();
                resultData[i][4] = currentSong.ratingToString();
            }
            printTable(resultHeaders, resultData);
            // After everything is printed, we ask the user if the want to print extra information
            System.out.println(BLUE + "Would you want to view more information about the song? (YES/NO): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("YES")) {
                for (int i = 0; i < searchResults.size(); i++) {
                    user.getSongData(searchResults.get(i));
                }
            }

        }
    }

    private void searchAlbum(String type) {
        clearScreen();

        if (type.equals("Music Store")) {
            // Display the search options table.
            String[] headers = {"Option", "Description"};
            String[][] options = {
                    {"1", "Search By Title"},
                    {"2", "Search By Artist"}
            };
            printTable(headers, options);

            int choice = getUserChoice();
            String searchTerm = "";
            ArrayList<Album> searchResults = new ArrayList<>();

            switch (choice) {
                case 1:
                    // Search by Title
                    while (searchTerm.trim().isEmpty()) {
                        System.out.print(YELLOW + "Enter Song Title: " + RESET);
                        searchTerm = scanner.nextLine();
                    }
                    searchResults = store.searchAlbum(false,true,"",searchTerm);
                    break;

                case 2:
                    // Search by Artist
                    while (searchTerm.trim().isEmpty()) {
                        System.out.print(YELLOW + "Enter Artist Name: " + RESET);
                        searchTerm = scanner.nextLine();
                    }
                    searchResults = store.searchAlbum(true,false,searchTerm,"");
                    break;

                default:
                    System.out.println("Invalid option selected.");
                    return;
            }

            // Check if search returned any results.
            if (searchResults.isEmpty()) {
                System.out.println("No Albums found for: " + searchTerm);
                return;
            }

            // Prepare table data for displaying search results.
            String[] resultHeaders = {"Title", "Artist", "Favorite?", "Rating"};
            String[][] resultData = new String[searchResults.size()][4];

            for (int i = 0; i < searchResults.size(); i++) {
                Album curr_album = searchResults.get(i);
                resultData[i][0] = curr_album.getTitle();
                resultData[i][1] = curr_album.getArtist();
                // Assuming a getAlbum() method exists; if not, adjust as needed.
                resultData[i][2] = curr_album.favoriteToString();
                resultData[i][3] = curr_album.ratingToString();
            }
            printTable(resultHeaders, resultData);
            System.out.println(YELLOW + "Which Album would you want to view?: " + RESET);
            int choice2 = getUserChoice();
            Album currentAlbum = searchResults.get(choice2-1);
            for (int i = 0; i < currentAlbum.getTracks().size(); i++) {
                System.out.println(currentAlbum.getTracks().get(i).getSongName());
            }
        } else {
            // User Library

            /// This is for the user library

            // Display the search options table.
            String[] headers = {"Option", "Description"};
            String[][] options = {
                    {"1", "Search By Title"},
                    {"2", "Search By Artist"}
            };
            printTable(headers, options);

            int choice = getUserChoice();
            String searchTerm = "";
            ArrayList<Album> searchResults = new ArrayList<>();

            switch (choice) {
                case 1:
                    // Search by Title
                    while (searchTerm.trim().isEmpty()) {
                        System.out.print(YELLOW + "Enter Song Title: " + RESET);
                        searchTerm = scanner.nextLine();
                    }
                    searchResults = user.searchAlbumByTitle(searchTerm);
                    break;

                case 2:
                    // Search by Artist
                    while (searchTerm.trim().isEmpty()) {
                        System.out.print(YELLOW + "Enter Artist Name: " + RESET);
                        searchTerm = scanner.nextLine();
                    }
                    searchResults = user.searchAlbumByArtist(searchTerm);
                    break;

                default:
                    System.out.println("Invalid option selected.");
                    return;
            }

            // Check if search returned any results.
            if (searchResults.isEmpty()) {
                System.out.println("No songs found for: " + searchTerm);
                return;
            }

            // Prepare table data for displaying search results.
            String[] resultHeaders = {"Title", "Artist", "Favorite?", "Rating"};
            String[][] resultData = new String[searchResults.size()][4];

            for (int i = 0; i < searchResults.size(); i++) {
                Album current_album = searchResults.get(i);
                resultData[i][0] = current_album.getTitle();
                resultData[i][1] = current_album.getArtist();
                resultData[i][2] = current_album.favoriteToString();
                resultData[i][3] = current_album.ratingToString();
            }
            printTable(resultHeaders, resultData);
            System.out.println(YELLOW + "Which Album would you want to view?: " + RESET);
            int choice2 = getUserChoice();
            Album currentAlbum = searchResults.get(choice2-1);
            for (int i = 0; i < currentAlbum.getTracks().size(); i++) {
                System.out.println(currentAlbum.getTracks().get(i).getSongName());
            }
        }
    }

    public void sellItem(String type) {
        clearScreen();
        if (type.equals("song")) {
            Song main_song;
            ArrayList<Song> songs = new ArrayList<>();
            while (songs.size() <= 0) {
                System.out.println("Enter Song Title: " + RESET);
                String title = scanner.nextLine();
                songs = store.searchSongByTitle(title);
            }
            if (songs.size() > 1) {
                System.out.println(RED + "You have more than one song found." + RESET);
                System.out.println("");
                String[] resultHeaders = {"#","Title", "Artist", "Album", "Favorite?", "Rating"};
                String[][] resultData = new String[songs.size()][6];

                for (int i = 0; i < songs.size(); i++) {
                    Song currentSong = songs.get(i);
                    resultData[i][0] = Integer.toString(i + 1);
                    resultData[i][1] = currentSong.getSongName();
                    resultData[i][2] = currentSong.getArtist();
                    // Assuming a getAlbum() method exists; if not, adjust as needed.
                    resultData[i][3] = currentSong.getAlbumTitle();
                    resultData[i][4] = currentSong.favoriteToString();
                    resultData[i][5] = currentSong.ratingToString();
                }
                printTable(resultHeaders, resultData);
                System.out.println(YELLOW + "Select which song to buy: " + RESET);
                int choice = getUserChoice();
                 main_song = songs.get(choice - 1);
            }
            else {
                main_song = songs.get(0);
            }
            // Remove song
            store.sellSong(main_song);
            System.out.println(GREEN + "SONG " + main_song.getSongName() + " has been added to your library." + RESET);
            user.addSong(main_song);
        }
        if (type.equals("album")) {
            Album main_album;
            ArrayList<Album> album = new ArrayList<>();
            while (album.size() <= 0) {
                System.out.println("Enter Album Title: " + RESET);
                String title = scanner.nextLine();
                album = store.searchAlbum(false,true,title,title);
            }
            if (album.size() > 1) {
                System.out.println(RED + "You have more than one song found." + RESET);
                System.out.println("");
                String[] resultHeaders = {"#","Title", "Artist", "Favorite?", "Rating"};
                String[][] resultData = new String[album.size()][6];

                for (int i = 0; i < album.size(); i++) {
                    Album curr_album = album.get(i);
                    resultData[i][0] = Integer.toString(i + 1);
                    resultData[i][1] = curr_album.getTitle();
                    resultData[i][2] = curr_album.getArtist();
                    // Assuming a getAlbum() method exists; if not, adjust as needed.
                    resultData[i][3] = curr_album.favoriteToString();
                    resultData[i][4] = curr_album.ratingToString();
                }
                printTable(resultHeaders, resultData);
                System.out.println(YELLOW + "Select which song to buy: " + RESET);
                int choice = getUserChoice();
                main_album = album.get(choice - 1);
            }
            else {
                main_album = album.get(0);
            }
            // Remove song
            store.sellAlbum(main_album);
            System.out.println(GREEN + "ALBUM " + main_album.getTitle() + " has been added to your library." + RESET);
            user.addAlbum(main_album);
        }
    }

    public void musicStoreInterface() {
        boolean storeMode = true;

        while (storeMode) {
            displayMusicStoreOptions();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    searchSong("Music Store");
                    promptEnterToContinue();
                    break;
                case 2:
                    searchAlbum("Music Store");
                    promptEnterToContinue();
                    break;
                case 3:
                    sellItem("song");
                    promptEnterToContinue();
                    break;
                case 4:
                    sellItem("album");
                    promptEnterToContinue();
                    break;
                case 5:
                    System.out.println(BLUE + "Returning to main menu..." + RESET);
                    storeMode = false;
                    break;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
                    promptEnterToContinue();
            }
        }
    }


    private void displayUserLibraryOptions() {
        clearScreen();
        printTitle("Music Library");

        String[] headers = {"Option", "Description"};
        String[][] data = {
                {"1", "Search for a Song"},
                {"2", "Search for a Album"},
                {"3", "Create a new Playlist"},
                {"4", "View Songs"},
                {"5", "View Playlists"},
                {"6", "Remove a Song"},
                {"7", "Exit"}
        };
        printTable(headers, data);
    }

    public void printSongs() {
        ArrayList<Song> songs = user.getUnprotectedSongs();
        String[] resultHeaders = {"Title", "Artist", "Album", "Favorite?", "Rating"};
        String[][] resultData = new String[songs.size()][5];

        for (int i = 0; i < songs.size(); i++) {
            Song currentSong = songs.get(i);
            resultData[i][0] = currentSong.getSongName();
            resultData[i][1] = currentSong.getArtist();
            // Assuming a getAlbum() method exists; if not, adjust as needed.
            resultData[i][2] = currentSong.getAlbumTitle();
            resultData[i][3] = currentSong.favoriteToString();
            resultData[i][4] = currentSong.ratingToString();
        }
        printTable(resultHeaders, resultData);
    }

    public void createNewPlaylist() {
        System.out.println("Creating new playlist...");
        System.out.println(YELLOW + "What do you want your playlist to be named?: " + RESET);
        String playlistName = scanner.nextLine();
        Playlist new_playlist = new Playlist(playlistName);
        user.addPlaylist(new_playlist);
        // Here we add functionality of adding songs to playlist
        boolean finished = false;
        while (!finished) {
            System.out.println("What songs from your library do you want to add? (Type done to finish): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("done")) {
                finished = true;
            }
            else {
                ArrayList<Song> searchResults = user.searchSongByTitle(choice);
                for (int i = 0; i < searchResults.size(); i++) {
                    new_playlist.addSong(searchResults.get(i).copy());
                }
            }
        }
        System.out.println(GREEN + "New playlist created!" + RESET);
    }

    public void viewPlaylists() {
        ArrayList<Playlist> user_playlists = user.getUserPlaylists();
        String[] resultHeaders = {"Title", "# Songs"};
        String[][] resultData = new String[user_playlists.size()][2];

        for (int i = 0; i < user_playlists.size(); i++) {
            Playlist currentSong = user_playlists.get(i);
            resultData[i][0] = user_playlists.get(i).getTitle();
            resultData[i][1] = Integer.toString(user_playlists.get(i).getSongs().size());
        }
        printTable(resultHeaders, resultData);
        System.out.println(YELLOW + "Which Playlist would you want to view?: " + RESET);
        int choice2 = getUserChoice();
        if (user.getUserPlaylists().size() >= 1) {
            Playlist playlist = user_playlists.get(choice2-1);
            for (int i = 0; i < playlist.getSongs().size(); i++) {
                System.out.println(playlist.getSongs().get(i).getSongName());
            }
        }
        else {
            System.out.println(RED + "No playlist found.");
        }
    }

    public void setRating() {
        String[] headers = {"Option", "Description"};
        String[][] options = {
                {"1", "Set a Rating for a Song"},
                {"2", "Set a Rating for a Album"}
        };
        printTable(headers, options);
        int choice = getUserChoice();
        switch (choice) {
            case 1: // Rating a song
                System.out.println("Enter the Title of the song: ");
                String title = scanner.nextLine();
                ArrayList<Song> songs = user.searchSongByTitle(title);
                // Rate the Song
                Song currentSong = songs.get(0);
                System.out.println("What do you want to rate the song?:(1 - 5) ");
                int choice2 = getUserChoice();
                currentSong.setRating(choice2);
        }

    }

    public void userLibraryInterface() {
        boolean libraryMode = true;

        while (libraryMode) {
            displayUserLibraryOptions();
            int choice = getUserChoice();

            switch (choice) {

                case 1:
                    searchSong("User Library");
                    promptEnterToContinue();
                    break;
                case 2:
                    searchAlbum("User Library");
                    promptEnterToContinue();
                    break;
                case 3:
                    createNewPlaylist();
                    promptEnterToContinue();
                    break;
                case 4:
                    printSongs();
                    promptEnterToContinue();
                    break;

                case 5:
                    viewPlaylists();

                case 6:
                    System.out.println(BLUE + "What Song do you want to remove?: " + RESET);
                    String song = scanner.nextLine();
                    boolean removed = user.removeSong(song);
                    if (removed) {
                        System.out.println(GREEN + "SUCCESSFULLY REMOVED" + RESET);
                    }
                    else {
                        System.out.println(RED + "ERROR: Song not found" + RESET);
                    }
                case 7:
                    System.out.println(BLUE + "Returning to main menu..." + RESET);
                    libraryMode = false;
                    break;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
                    promptEnterToContinue();
            }
        }
    }
}