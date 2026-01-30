package controller;

import model.Author;
import model.BookBase;
import model.PrintedBook;
import model.EBook;
import repository.AuthorRepository;
import service.LibraryService;
import utils.SortingUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LibraryService libraryService = new LibraryService();
        AuthorRepository authorRepo = new AuthorRepository();

        System.out.println("=== Library Management System Initializing ===");

        try {
            Author author1 = new Author("George Orwell", "British");
            Author author2 = new Author("Dan Brown", "American");

            System.out.println("\n[Step 1] Saving Authors...");
            authorRepo.create(author1);
            authorRepo.create(author2);

            BookBase book1 = new PrintedBook(0, "1984", 0.85);
            BookBase book2 = new EBook(0, "Digital Fortress", "EPUB");

            System.out.println("\n[Step 2] Adding Books via Service Layer...");
            libraryService.addBook(book1);
            libraryService.addBook(book2);

            List<BookBase> books = new ArrayList<>();
            books.add(book1);
            books.add(book2);

            SortingUtils.sortBooksByTitle(books);

            System.out.println("\n[Step 3] Books sorted by title (Lambda):");
            books.forEach(book -> System.out.println(book.getTitle()));
            // ====================================

            System.out.println("\n[Step 4] Processing Books Polymorphically:");
            books.forEach(Main::processBookDetails);

            System.out.println("\n=== All operations completed successfully! ===");

        } catch (Exception e) {
            System.err.println("\nCritical Error: " + e.getMessage());
        }
    }

    public static void processBookDetails(BookBase book) {
        System.out.println("------------------------------------");
        book.printBaseStatus();
        book.displayInfo();
        System.out.println("Type: " + book.getBookType());
        System.out.println("\n[Step 5] Reflection info about BookBase:");

        Class<?> bookClass = BookBase.class;

        System.out.println("Class name: " + bookClass.getName());

        System.out.println("Fields:");
        for (var field : bookClass.getDeclaredFields()) {
            System.out.println("- " + field.getName());
        }

        System.out.println("Methods:");
        for (var method : bookClass.getDeclaredMethods()) {
            System.out.println("- " + method.getName());
        }

        System.out.println("Calculated Late Fee (7 days): $" + book.calculateLateFee(7));
    }
}