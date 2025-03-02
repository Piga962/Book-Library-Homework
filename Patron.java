import java.util.List;
import java.util.ArrayList;


public class Patron extends Person {
    private int patronId;
    private List<Book> booksBorrowed;


    public Patron(String name, String address, String phoneNumber, String email, int patronId) {
        super(name, address, phoneNumber, email);
        this.patronId = patronId;
        booksBorrowed = new ArrayList<>();
    }

    public int getPatronId() {
        return patronId;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setPatronId(int patronId) {
        this.patronId = patronId;
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    public void borrowBook(Book book) {
        booksBorrowed.add(book);
    }

    public void returnBook(Book book) {
        booksBorrowed.remove(book);
    }

}
