package Libary.Com;

import Model.Person;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Person> requestQueue = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void showAvailableBooks() {
        System.out.println("Available books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

    public void requestBook(Person person) {
        requestQueue.add(person);
        System.out.println(person.getName() + " has requested a book.");
    }

    public void lendBook(Book book) {
        if (!book.isAvailable()) {
            System.out.println("Book '" + book.getTitle() + "' is not available.");
            return;
        }

        if (requestQueue.isEmpty()) {
            System.out.println("No one in the queue to lend the book to.");
            return;
        }

        Person person = requestQueue.remove(0);
        book.setAvailable(false);
        System.out.println("Book '" + book.getTitle() + "' has been lent to " + person.getName());
    }
}
