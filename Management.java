import java.util.List;
import java.util.ArrayList;

public class Management {
    private List<Book> bookShelf;
    private List<Patron> patrons;

    public Management() {
        bookShelf = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public List<Book> getBookShelf() {
        return bookShelf;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public void setBookShelf(List<Book> bookShelf) {
        this.bookShelf = bookShelf;
    }

    public void setPatrons(List<Patron> patrons) {
        this.patrons = patrons;
    }

    public void displayBookShelf() {
        for (Book book : bookShelf) {
            System.out.println("********************************");
            book.displayBookInfo();
        }
    }

    public void displayPatrons() {
        for (Patron patron : patrons) {
            System.out.println("Patron ID: " + patron.getPatronId());
            System.out.println("Name: " + patron.getName());
            System.out.println("Address: " + patron.getAddress());
            System.out.println("Phone Number: " + patron.getPhoneNumber());
            System.out.println("Email: " + patron.getEmail());
            System.out.println("Books Borrowed: ");
            for (Book book : patron.getBooksBorrowed()) {
                book.displayBookInfo();
            }
        }
    }

    public void addBookToShelf(Book book) {
        bookShelf.add(book);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void removeBookFromShelf(Book book) {
        bookShelf.remove(book);
    }

    public void removePatron(Patron patron) {
        patrons.remove(patron);
    }

    public void borrowBook(Patron patron, Book book){
        int availableCopies = book.getAvailableCopies();
        if (availableCopies > 0) {
            patron.borrowBook(book);
            book.setAvailableCopies(availableCopies - 1);
        } else {
            System.out.println("No available copies of " + book.getTitle() + " to borrow.");
        }
    }

    public void returnBook(Patron patron, Book book) {
        patron.returnBook(book);
        book.setAvailableCopies(book.getAvailableCopies() + 1);
    }

    public void searchBookByTitle(String title) {
        for (Book book : bookShelf) {
            if (book.getTitle().equals(title)) {
                book.displayBookInfo();
            }
        }
    }

    public void searchBookByAuthor(String author) {
        for (Book book : bookShelf) {
            if (book.getAuthor().contains(author)) {
                book.displayBookInfo();
            }
        }
    }

    public void searchBookByISBN(String isbn) {
        for (Book book : bookShelf) {
            if (book.getIsbn().equals(isbn)) {
                book.displayBookInfo();
            }
        }
    }

}
