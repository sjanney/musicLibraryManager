
/*
// Necessary Packages and Libraries
package view;
import java.util.Scanner;


public class MusicLibraryUI {
    // Create a new scanner object that takes in input stream from user
    private static Scanner scanner = new Scanner(System.in);

    // These are color codes that are used within the termial us (*created with AI)
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";


    public static void main(String[] args) {
        // Main instance that is running when user enter's program
        while (true) {
            displayMainMenu();
            int choice = getUserChoice();
            handleMainMenuChoice(choice);
        }
    }

    private static void displayMainMenu() {
        clearScreen();
        printTitle("Music Library System");

        String[] headers = {"Option", "Description"};
        String[][] data = {
                {"1", "Search Music Store"},
                {"2", "Search User Library"},
                {"3", "Add to Library"},
                {"4", "View Library"},
                {"5", "Exit"}
        };

        printTable(headers, data);
    }

    private static void displaySearchMenu() {
        clearScreen();
        printTitle("Search Music Store");

        String[] headers = {"Option", "Description"};
        String[][] data = {
                {"1", "Search song by title"},
                {"2", "Search song by artist"},
                {"3", "Search album by title"},
                {"4", "Search album by artist"},
                {"5", "Back to main menu"}
        };

        printTable(headers, data);
    }

    private static void displayLibrary() {
        clearScreen();
        printTitle("Your Library");

        // Example library data
        String[] headers = {"#", "Title", "Artist", "Album", "Duration"};
        String[][] data = {
                {"1", "Bohemian Rhapsody", "Queen", "A Night at the Opera", "5:55"},
                {"2", "Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV", "8:02"},
                {"3", "Hotel California", "Eagles", "Hotel California", "6:30"}
        };

        printTable(headers, data);
        promptEnterToContinue();
    }

    private static void searchSongs(String searchTerm, String searchType) {
        clearScreen();
        printTitle("Search Results for: " + searchTerm);

        // Example search results
        String[] headers = {"Title", "Artist", "Album", "Duration"};
        String[][] data = {
                {"Bohemian Rhapsody", "Queen", "A Night at the Opera", "5:55"},
                {"Radio Ga Ga", "Queen", "The Works", "5:48"}
        };

        printTable(headers, data);
        promptEnterToContinue();
    }



        // Print header
        printTableLine(columnWidths);
        for (int i = 0; i < headers.length; i++) {
            System.out.print("| " + CYAN + padRight(headers[i], columnWidths[i]) + RESET + " ");
        }
        System.out.println("|");
        printTableLine(columnWidths);

        // Print data
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                System.out.print("| " + padRight(row[i], columnWidths[i]) + " ");
            }
            System.out.println("|");
        }
        printTableLine(columnWidths);
    }

    private static void printTableLine(int[] columnWidths) {
        System.out.print("+");
        for (int width : columnWidths) {
            System.out.print("-".repeat(width + 2) + "+");
        }
        System.out.println();
    }

    private static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    private static void printTitle(String title) {
        System.out.println(PURPLE + "\n=== " + title + " ===" + RESET + "\n");
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int getUserChoice() {
        System.out.print(YELLOW + "Enter your choice: " + RESET);
        while (!scanner.hasNextInt()) {
            System.out.println(RED + "Please enter a valid number." + RESET);
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void promptEnterToContinue() {
        System.out.println(YELLOW + "\nPress Enter to continue..." + RESET);
        scanner.nextLine();
        if (scanner.hasNextLine()) scanner.nextLine();
    }

    private static void handleMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                handleSearchMenu();
                break;
            case 2:
                // Implement library search
                System.out.println(YELLOW + "Library search functionality coming soon!" + RESET);
                promptEnterToContinue();
                break;
            case 3:
                // Implement add to library
                System.out.println(YELLOW + "Add to library functionality coming soon!" + RESET);
                promptEnterToContinue();
                break;
            case 4:
                displayLibrary();
                break;
            case 5:
                System.out.println(GREEN + "Thank you for using the Music Library System!" + RESET);
                System.exit(0);
            default:
                System.out.println(RED + "Invalid choice. Please try again." + RESET);
                promptEnterToContinue();
        }
    }

    private static void handleSearchMenu() {
        while (true) {
            displaySearchMenu();
            int choice = getUserChoice();

            if (choice == 5) break;

            if (choice >= 1 && choice <= 4) {
                System.out.print(YELLOW + "Enter search term: " + RESET);
                scanner.nextLine(); // Consume newline
                String searchTerm = scanner.nextLine();
                searchSongs(searchTerm, "title"); // Example search
            } else {
                System.out.println(RED + "Invalid choice. Please try again." + RESET);
                promptEnterToContinue();
            }
        }
    }
}

 */