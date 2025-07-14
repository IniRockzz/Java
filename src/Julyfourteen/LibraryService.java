package Julyfourteen;

import java.util.Scanner;
        // class
public class LibraryService extends User{    //inheritance
    public LibraryService(String username, String password, String role) {
        super(username, password, role);
    }

    public static void main(String[] args) {
        Library lb = new Library(); // objects
        Scanner sc = new Scanner(System.in);
        User users = login(sc);

        if (users == null) {
            System.out.println("Exiting, failed to login.");
            return;
        }

        System.out.println("Logged in as " + users);

        while (true) {
            System.out.println("\n Library Menu (" + users.getRole() + ") ====");
            showMenuForRole(users.getRole());

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            boolean exit = handleChoice(choice, users.getRole(), lb, sc);
            if (exit) break;
        }

        sc.close();
    }



    private static void showMenuForRole(String role) {
        switch (role) {
            case "Manager":
                System.out.println("1. Add Book \n 2. View Books \n 3. Search Books \n 4. Delete Book \n 5. Exit");
                break;
            case "Employee":
                System.out.println("1. View Books \n 2. Search Books \n 3. Borrow Book \n 4. Return Book \n 5. Exit");
                break;
            case "User":
                System.out.println("1. View Books \n 2. Search Books \n 3. Exit");
                break;
        }
    }

    private static boolean handleChoice(int choice, String role, Library lb, Scanner sc) {
        switch (role) {
            case "Manager":
                return handleManagerChoice(choice, lb, sc);
            case "Employee":
                return handleEmployeeChoice(choice, lb, sc);
            case "User":
                return handleUserChoice(choice, lb, sc);
            default:
                System.out.println("Unknown role.");
                return false;
        }
    }

    private static boolean handleManagerChoice(int choice, Library lb, Scanner sc) {
        switch (choice) {
            case 1:
                System.out.print("Enter book title: ");
                String title = sc.nextLine();
                System.out.print("Enter author: ");
                String author = sc.nextLine();
                lb.addBook(title, author);
                break;
            case 2:
                lb.viewBooks();
                break;
            case 3:
                System.out.print("Enter keyword: ");
                String keyword = sc.nextLine();
                lb.searchByKeyword(keyword);
                break;
            case 4:
                System.out.print("Enter book ID to delete: ");
                int deleteId = sc.nextInt();
                sc.nextLine();
                lb.deleteBook(deleteId);
                break;
            case 5:
                System.out.println(" Goodbye Manager!");

            default:
                System.out.println(" Invalid option.");
        }
        return false;
    }

    private static boolean handleEmployeeChoice(int choice, Library lb, Scanner sc) {
        switch (choice) {
            case 1:
                lb.viewBooks();
                break;
            case 2:
                System.out.print("Enter keyword: ");
                String keyword = sc.nextLine();
                lb.searchByKeyword(keyword);
                break;
            case 3:
                System.out.print("Enter book ID to borrow: ");
                int borrowId = sc.nextInt();
                sc.nextLine();
                lb.borrowBook(borrowId);
                break;
            case 4:
                System.out.print("Enter book ID to return: ");
                int returnId = sc.nextInt();
                sc.nextLine();
                lb.returnBook(returnId);
                break;
            case 5:
                System.out.println("Goodbye Employee!");
                return true;
            default:
                System.out.println(" Invalid option.");
        }
        return false;
    }

    private static boolean handleUserChoice(int choice, Library library, Scanner scanner) {
        switch (choice) {
            case 1:
                library.viewBooks();
                break;
            case 2:
                System.out.print("Enter keyword: ");
                String keyword = scanner.nextLine();
                library.searchByKeyword(keyword);
                break;
            case 3:
                System.out.println("Goodbye User!");
                return true;
            default:
                System.out.println("Invalid option.");
        }
        return false;
    }
}

