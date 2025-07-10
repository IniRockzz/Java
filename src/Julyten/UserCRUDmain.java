package Julyten;

import java.util.ArrayList;
import java.util.Scanner;

import static Julyten.Usermanager.*;



public class UserCRUDmain {
    private static ArrayList<User> users = new ArrayList<>(); // collection
    private static Scanner sc = new Scanner(System.in);// method or function
    Usermanager usermanager = new Usermanager();

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
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();


                switch (choice) {
                    case 1 -> createuser();// rule switch
                    case 2 -> readuser();
                    case 3 -> updateuser();
                    case 4 -> deleteuser();
                    case 5 -> running = false;
                    default -> System.out.println("Invaild choice");
                }
            }else {
                System.out.println("Invalid choice, please enter a number");
                sc.nextLine();
            }


        }
        System.out.println("Byeeee");
    }

}
