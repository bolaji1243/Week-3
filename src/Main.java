import Libary.Com.Book;
import Libary.Com.Library;
import Model.JuniorStudent;
import Model.Person;
import Model.SeniorStudent;
import Model.Teacher;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();



        Book book1 = new Book("Math", "Emmanuel");
        library.addBook(book1);


        Person teacher = new Teacher("Mr. John", 31);
        Person juniorStudent = new JuniorStudent("Aliyu", 12);
        Person seniorStudent = new SeniorStudent("Blessing", 14);

        juniorStudent.requestBook(library);
        teacher.requestBook(library);
        seniorStudent.requestBook(library);


        library.showAvailableBooks();


        library.lendBook(book1);


    }
}
