package Julynine;

import java.util.ArrayList;
import java.util.Scanner;

public class Crud {
    private static ArrayList<String> users = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main (String[]args){
        boolean running = true;

        while(running){
            System.out.println("\n1.Create user");
            System.out.println("2.Read user");
            System.out.println("3.Update  user");
            System.out.println("4.Delete user");
            System.out.println("5.Exit");
            System.out.println("Choose option");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 -> createuser();
                case 2 -> readuser();
                case 3 -> updateuser();
                case 4 -> deleteuser();
                case 5 -> running = false;
                default -> System.out.println("Invaild choice");
            }

        }


    }
        private static void createuser(){
            System.out.println("Enter the username:");
            String name = sc.nextLine();
            if (users.contains(name)) {
                System.out.println("user already exist,choose another name:");
            } else{
                users.add(name);
                System.out.println("User is added");
                }

        }
        private static void readuser() {
               System.out.println("User list");
               if(users.isEmpty()) {
                   System.out.println("User not found");
               }
               else {
                   for(int i=0 ; i< users.size();i++){
                       System.out.println(i +":"+ users.get(i));
                   }

               }

        }
        private static void updateuser(){
                readuser();
                System.out.println("Enter the index of the user to be updated:");
                int index = sc.nextInt();
                sc.nextLine();

                if (index >= 0 && index < users.size()){
                    System.out.println("Enter the username");
                    String newname = sc.nextLine();
                    users.add(newname);
                    System.out.println("user is updated");
                } else {
                    System.out.println("Invalid index");
                }

        }
        private static void deleteuser(){
                readuser();
                System.out.println("Enter the index of the user to be delete ");
                int index = sc.nextInt();
                sc.nextLine();

            if (index >= 0 && index < users.size()){
                users.remove(index);
                System.out.println("user is deleted");
            } else {
                System.out.println("Invalid index");
            }
        }
}

