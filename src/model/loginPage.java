package model;

import java.security.SecureRandom;
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

    }
}
