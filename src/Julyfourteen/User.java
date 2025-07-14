package Julyfourteen;

import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String role; // Manager, Employee, User

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    static User[] systemUsers = {
            new User("prasanna", "1234", "Manager"),
            new User("mathanraj", "1234", "Employee"),
            new User("jaiakash", "1234", "User")

    };

    public static User login(Scanner sc) {
        System.out.println("Login");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        for (User u : systemUsers) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }

        System.out.println("Invalid Input.");
        return null;
    }

    @Override
    public String toString() {
        return "User: " + username + " (" + role + ")";
    }
}

