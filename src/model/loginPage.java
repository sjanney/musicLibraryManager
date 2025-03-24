package model;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Scanner;

public class loginPage {
    userDatabase db;
    Scanner scanner = new Scanner(System.in);

    public loginPage() {
        this.db = new userDatabase();
    }

    public void registerUser() {
        //First, we get the user's credientials
        System.out.println("Registering user...");
        System.out.println(" What do you want your Username to be?");
        String username = scanner.nextLine();
        System.out.println(" What do you want your Password to be?");
        String password = scanner.nextLine();
        // We then generate our salt
        byte[] salt_length = new byte[5]; // Creating a 5 length salt
        new SecureRandom().nextBytes(salt_length);
        String salt = Base64.getEncoder().encodeToString(salt_length);
        // After we do this, we then hash the password with the salt we created
        try {
            // We define our iterations and key length
            int iterations = 10000;
            int keyLength = 256;
            // Create a key using SHA-2 Algo
            SecretKeyFactory key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            //Generate's new password in Base 64
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt_length, iterations, keyLength );
            // Convert to String
            String hashedPassword = Base64.getEncoder().encodeToString(key.generateSecret(spec).getEncoded() );

            // Then we finally place them inside of our userdatabase
            String[] auth_data = new String[2];
            auth_data[0] = salt;
            auth_data[1] = hashedPassword;
            this.db.addUser(username, auth_data);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }


    public String verifyUser() {
        // We gather the user credientials first
        System.out.println("Verifying user...");
        System.out.println("Enter your Username:");
        String username = scanner.nextLine();
        System.out.println("Enter your Password:");
        String password = scanner.nextLine();

        // Retrieve the stored authentication data (salt and hashed password) from the database
        String[] auth_data = this.db.getUserAuthData(username);
        if (auth_data == null || auth_data.length < 2) {
            System.out.println("User not found or invalid authentication data.");
            return null;
        }
        String storedSalt = auth_data[0];
        String storedHashedPassword = auth_data[1];

        // After that, we hash the inputted password with the collected previous salt
        try {
            int iterations = 10000;
            int keyLength = 256;
            SecretKeyFactory key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] saltBytes = Base64.getDecoder().decode(storedSalt);
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, iterations, keyLength);
            String hashedPassword = Base64.getEncoder().encodeToString(key.generateSecret(spec).getEncoded());

            // Compare the newly hashed password with the stored hashed password
            if (hashedPassword.equals(storedHashedPassword)) {
                System.out.println("User verified successfully!");
                return username; // Passwords match
            } else {
                System.out.println("Invalid username or password.");
                return null; // Passwords do not match
            }
        } catch (Exception e) {
            System.err.println("Error during password verification: " + e.getMessage());
        }
        return null;
    }


    public String startApplication() {
        // AI-generated: Frontend method to allow user to choose between register and login
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // ANSI color codes
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String PURPLE = "\u001B[35m";
        String CYAN = "\u001B[36m";
        String BOLD = "\u001B[1m";

        while (running) {
            // Table header
            System.out.println(CYAN + "==============================================" + RESET);
            System.out.println(BOLD + BLUE + "       Welcome to the Music Application!       " + RESET);
            System.out.println(CYAN + "==============================================" + RESET);
            System.out.println(BOLD + GREEN + "| Option |            Description            |" + RESET);
            System.out.println(CYAN + "----------------------------------------------" + RESET);
            System.out.println(BOLD + YELLOW + "|   1    | Register a new account           |" + RESET);
            System.out.println(BOLD + YELLOW + "|   2    | Login to your account            |" + RESET);
            System.out.println(BOLD + YELLOW + "|   3    | Exit the application             |" + RESET);
            System.out.println(CYAN + "==============================================" + RESET);

            // Prompt for user input
            System.out.print(BOLD + PURPLE + "Choose an option (1, 2, or 3): " + RESET);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerUser();
                    break;
                case "2":
                    String username = verifyUser();
                    if (username != null) {
                        System.out.println(GREEN + "Welcome back, " + username + "!" + RESET);
                        return username;
                    } else {
                        System.out.println(RED + "Login failed. Please try again." + RESET);
                    }
                    break;
                case "3":
                    System.out.println(BLUE + "Exiting the application. Goodbye!" + RESET);
                    running = false;
                    return "STOP";
                default:
                    System.out.println(RED + "Invalid choice. Please select 1, 2, or 3." + RESET);
                    break;
            }
        }
        scanner.close();
        return null;
    }

}
