package Julyfourteen;


import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private int nextId = 1;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        books.add(new Book(nextId++, title, author));
        System.out.println(" Book added successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in Library:");
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    public void borrowBook(int id) {
        Book b = findById(id);
        if (b != null) {
            if (!b.isBorrowed()) {
                b.borrow();
                System.out.println("Book borrowed successfully");
            } else {
                System.out.println(" Book is already borrowed");
            }
        } else {
            System.out.println("Book not found");
        }
    }

    public void returnBook(int id) {
        Book b = findById(id);
        if (b != null) {
            if (b.isBorrowed()) {
                b.returnBook();
                System.out.println("Book returned successfully");
            } else {
                System.out.println(" Book was not borrowed");
            }
        } else {
            System.out.println(" Book not found.");
        }
    }

    public void searchByKeyword(String keyword) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" No matching books found for keyword: " + keyword);
        }
    }

    public void searchById(int id) {
        Book b = findById(id);
        if (b != null) {
            System.out.println(" Book found: " + b);
        } else {
            System.out.println("Book not found with ID: " + id);
        }
    }

    public void searchByExactTitle(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with exact title: " + title);
        }
    }

    public void deleteBook(int id) {
        Book b = findById(id);
        if (b != null) {
            books.remove(b);
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found with ID: " + id);
        }
    }

    private Book findById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }
}
