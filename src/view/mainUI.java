package view;
import model.*;
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

    public void startInstance() {
        // This methods create's the instance of the UI, allowing it to be ran until terminated
        while (true) {
            displayMainMenu();
            int choice = getUserChoice();
            handleMainMenuChoice(choice);
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
                {"4", "View Library"},
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
        return String.format("%-" + n + "s", s);
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void promptEnterToContinue() {
        System.out.println(YELLOW + "\nPress Enter to continue..." + RESET);
        scanner.nextLine();
    }

    private void handleMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                musicStoreInterface();
                //System.out.println(YELLOW + "Music Store - Coming Soon!" + RESET);
                promptEnterToContinue();
                break;
            case 2:
                userLibraryInterface();
                //System.out.println(YELLOW + "User Library - Coming Soon!" + RESET);
                promptEnterToContinue();
                break;
            case 3:
                System.out.println(YELLOW + "Create New Playlist - Coming Soon!" + RESET);
                promptEnterToContinue();
                break;
            case 4:
                System.out.println(YELLOW + "View Library - Coming Soon!" + RESET);
                promptEnterToContinue();
                break;
            case 5:
                System.out.println(YELLOW + "Set Favorites - Coming Soon!" + RESET);
                promptEnterToContinue();
                break;
            case 6:
                System.out.println(GREEN + "Thank you for using the Music Library System!" + RESET);
                System.exit(0);
                break;
            default:
                System.out.println(RED + "Invalid choice. Please try again." + RESET);
                promptEnterToContinue();
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
        handleMusicStoreOptions();
    }

    private void handleMusicStoreOptions() {
        // This code with handle whatever the user enters
    }

    public void musicStoreInterface() {
        boolean storeMode = true;

        while (storeMode) {
            displayMusicStoreOptions();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    System.out.println(YELLOW + "Search for a Song - Coming Soon!" + RESET);
                    promptEnterToContinue();
                    break;
                case 2:
                    System.out.println(YELLOW + "Search for an Album - Coming Soon!" + RESET);
                    promptEnterToContinue();
                    break;
                case 3:
                    System.out.println(YELLOW + "Buy Song to Library - Coming Soon!" + RESET);
                    promptEnterToContinue();
                    break;
                case 4:
                    System.out.println(YELLOW + "Buy Album to Library - Coming Soon!" + RESET);
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
                {"5", "Exit"}
        };
        printTable(headers, data);
        handleMusicStoreOptions();
    }

    public void userLibraryInterface() {
        boolean libraryMode = true;

        while (libraryMode) {
            displayUserLibraryOptions();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    System.out.println(YELLOW + "Search for a Song - Coming Soon!" + RESET);
                    promptEnterToContinue();
                    break;
                case 2:
                    System.out.println(YELLOW + "Search for a Album - Coming Soon!" + RESET);
                    promptEnterToContinue();
                    break;
                case 3:
                    System.out.println(YELLOW + "Create a new Playlist - Coming Soon!" + RESET);
                    promptEnterToContinue();
                    break;
                case 4:
                    System.out.println(YELLOW + "View Songs - Coming Soon!" + RESET);
                    promptEnterToContinue();
                    break;
                case 5:
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