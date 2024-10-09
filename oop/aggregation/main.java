import java.util.List;
import java.util.ArrayList;

// Part class (Book)
class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

// Whole class (Library)
class Library {
    String name;
    List<Book> books;  // Aggregation

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);  // Aggregating books in the library
    }

    public void displayLibraryInfo() {
        System.out.println("Library: " + name);
        System.out.println("Books in library:");
        for (Book book : books) {
            book.displayBookInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating books
        Book book1 = new Book("Effective Java", "Joshua Bloch");
        Book book2 = new Book("Clean Code", "Robert C. Martin");

        // Creating a library and adding books
        Library library = new Library("City Library");
        library.addBook(book1);
        library.addBook(book2);

        // Displaying library information
        library.displayLibraryInfo();
    }
}