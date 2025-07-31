package Libary.Com;
import Model.Person;
import Model.Teacher;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();

    private PriorityQueue<Person> requestQueue = new PriorityQueue<>(new Comparator<Person>() {
        @Override
         public int compare(Person first, Person secound) {
            if (first instanceof Teacher && !(secound instanceof Teacher)) {
                return -1; // Teacher first
            } else if (!(first instanceof Teacher) && secound instanceof Teacher) {
                return 1;  // Student after
            } else {
                return 0;
            }
        }
    });

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
        saveRequestToFile(person);
        System.out.println(person.getName() + " has requested a book.");
    }

    public void saveRequestToFile(Person person) {
        try (FileWriter writer = new FileWriter("requests.txt", true)) {
            writer.write(person.getName() + " - " + person.getClass().getSimpleName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lendBook(Book book) {
        if (!book.isAvailable()) {
            System.out.println("Sorry, the book is already lent out.");
            return;
        }

        if (!requestQueue.isEmpty()) {
            Person person = requestQueue.poll();
            book.setAvailable(false);
            System.out.println(book.getTitle() + " has been lent to " + person.getName() + " (" + person.getClass().getSimpleName() + ")");
        } else {
            System.out.println("No requests in the queue for this book.");
        }
    }
}
