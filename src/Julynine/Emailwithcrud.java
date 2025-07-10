package Julynine;

import java.util.ArrayList;
import java.util.Scanner;

public class Emailwithcrud {
     static class User {
        String username; //variable
        String email;
        String password;

        // () parameter
        public User(String username, String email, String password) {
            this.username = username; // reference variable
            this.email = email;
            this.password = password;
        }
    }
    private static  ArrayList<User> users = new ArrayList<>(); // collection
    private static  Scanner sc = new Scanner(System.in); // method or function

    // main function
    public static void main (String[]args){


        boolean running = true;// controller
        while (running){
            System.out.println("\n1.Create User");
            System.out.println("2.Read user");
            System.out.println("3.Update  user");
            System.out.println("4.Delete user");
            System.out.println("5.Exit");
            System.out.println("Choose option");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 -> createuser();// rule switch
                case 2 -> readuser();
                case 3 -> updateuser();
                case 4 -> deleteuser();
                case 5 -> running = false;
                default -> System.out.println("Invaild choice");
            }


        }
        System.out.println("Byeeee");
    }

    // function
    private static void createuser() {
        System.out.println("Enter the username:");
        String username = sc.nextLine();

        System.out.println("Enter the email:");
          String email = sc.nextLine();
        if (email.contains("@gmail.com")) {
            System.out.println("valid email");
        }else{
            System.out.println("Invalid email");
            return ;
        }

        System.out.println("Enter the password:");
        String password = sc.nextLine();

        for (User user : users) {
            if (user.email.equals(email)) {
                System.out.println("User already exists. Choose another email.");
                return;
            }
        }

        users.add(new User(username, email, password));
        System.out.println("User added successfully.");


    }
    private static void readuser(){
        System.out.println("\nUser List");
        if (users.isEmpty()){
            System.out.println("User is not found");
        } else {
            for (int i=0 ; i< users.size();i++){
                User user = users.get(i);
                System.out.println(i + ": \nUserName :" + user.username + "\n Email: " +user.email + "\n Password: " + user.password );
            }
        }

    }
    private static void updateuser(){
        readuser(); // calling function
        System.out.println("Enter the index value of the user:");

        // new scanner method , for exceptional handling
        if(sc.hasNextInt()) {
            int index = sc.nextInt();
            sc.nextLine();


            if (index >= 0 && index < users.size()) {
                System.out.println("Enter the new username:");
                String newusername = sc.nextLine();

                System.out.println("Enter the new email:");
                String newemail = sc.nextLine();

                System.out.println("Enter the new password:");
                String newpassword = sc.nextLine();

                users.set(index, new User(newusername, newemail, newpassword));
                System.out.println("User Updated");
            } else {
                System.out.println("Invalid index");
            }
        } else {
            System.out.println("invalid input, use number for index");
            sc.nextLine();
        }


    }
     private static void deleteuser() {
        readuser();

         System.out.println("Enter the index of the user to delete:");

         if (sc.hasNextInt()) {
             int index = sc.nextInt();
             sc.nextLine();

             if (index >= 0 && index < users.size()) {
                 users.remove(index);
                 System.out.println("user is deleted");
             } else {
                 System.out.println("Invalid index");
             }

         } else {
             System.out.println("Invalid input,use number for index");
             sc.nextLine();
         }

    }


}




