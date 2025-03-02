import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Management management = new Management();
        Librarian librarian = new Librarian("Cesar Mecinas", "Monte Kenia 430, Monterrey, Nuevo Leon", "4791764956", "cesarjrmecinas@gmail.com", 1, management);
        // Create books
        List<Book> bookShelf = management.getBookShelf();

        bookShelf.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925, 5));
        bookShelf.add(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", 1960, 3));
        bookShelf.add(new Book("1984", "George Orwell", "9780451524935", 1949, 2));
        bookShelf.add(new Book("Pride and Prejudice", "Jane Austen", "9780679783268", 1813, 4));
        bookShelf.add(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488", 1951, 1));
        bookShelf.add(new Book("The Hobbit", "J.R.R. Tolkien", "9780618260300", 1937, 6));

        // Create patrons
        List<Patron> patrons = management.getPatrons();
        Patron patron1 = new Patron("John Doe", "123 Main St, Anytown, USA", "555-1234","johndoe@gmail.com", 1);
        librarian.addPatron(patron1);

        int userType = 1;
        if(userType == 1){
            int option = 0;
            System.out.println("Welcome, Librarian!");
            while(option != 6){
                System.out.println("What would you like to do?");
                System.out.println("1. Add a book to the shelf");
                System.out.println("2. Remove a book from the shelf");
                System.out.println("3. Display the book shelf");
                System.out.println("4. Add a patron");
                System.out.println("5. Display patrons");
                System.out.println("6. Exit");
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("Enter the title of the book: ");
                        String title = scanner.nextLine();
                        System.out.println("Enter the author of the book: ");
                        String author = scanner.nextLine();
                        System.out.println("Enter the ISBN of the book: ");
                        String isbn = scanner.nextLine();
                        System.out.println("Enter the year the book was published: ");
                        int yearPublished = scanner.nextInt();
                        System.out.println("Enter the number of copies available: ");
                        int availableCopies = scanner.nextInt();
                        scanner.nextLine();
                        Book newBook = new Book(title, author, isbn, yearPublished, availableCopies);
                        librarian.addBookToShelf(newBook);
                        break;
                    case 2:
                        System.out.println("Enter the title of the book you want to remove: ");
                        String titleToRemove = scanner.nextLine();
                        boolean bookRemoved = false;
                        for (Book book : management.getBookShelf()) {
                            if (book.getTitle().equals(titleToRemove)) {
                                librarian.removeBookFromShelf(book);
                                bookRemoved = true;
                                System.out.println(titleToRemove + " has been removed from the shelf.");
                                break;
                            }
                        }
                        if (!bookRemoved) {
                            System.out.println("Book not found.");
                        }
                        break;
                    case 3:
                        librarian.displayBookShelf();
                        break;
                    case 4:
                        System.out.println("Enter the name of the patron: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter the address of the patron: ");
                        String address = scanner.nextLine();
                        System.out.println("Enter the phone number of the patron: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Enter the email of the patron: ");
                        String email = scanner.nextLine();
                        System.out.println("Enter the patron ID: ");
                        int patronId = scanner.nextInt();
                        scanner.nextLine();
                        Patron newPatron = new Patron(name, address, phoneNumber, email, patronId);
                        librarian.addPatron(newPatron);
                        break;
                    case 5:
                        librarian.displayPatrons();
                        break;
                    case 6:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }

            }
        } else {
            int option = 0;
            System.out.println("Welcome, Patron!");
            while(option != 7){
                System.out.println("What would you like to do?");
                System.out.println("1. Borrow a book");
                System.out.println("2. Return a book");
                System.out.println("3. Search for a book by title");
                System.out.println("4. Search for a book by author");
                System.out.println("5. Search for a book by ISBN");
                System.out.println("6. Display the book shelf");
                System.out.println("7. Exit");
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("Enter the title of the book you want to borrow: ");
                        String title = scanner.nextLine();
                        boolean bookFound = false;
                        for (Book book : management.getBookShelf()) {
                            System.out.println(book.getTitle());
                            if (book.getTitle().equals(title)) {
                                management.borrowBook(patron1, book);
                                bookFound = true;
                                System.out.println("You have borrowed " + title + ".");
                                break;
                            }
                        }
                        if (!bookFound) {
                            System.out.println("Book not found.");
                        }
                        break;
                    case 2:
                        System.out.println("Enter the title of the book you want to return: ");
                        String titleToReturn = scanner.nextLine();
                        boolean bookReturned = false;
                        for(Book book : patron1.getBooksBorrowed()){
                            System.out.println(book.getTitle());
                            if(book.getTitle().equals(titleToReturn)){
                                management.returnBook(patron1, book);
                                bookReturned = true;
                                System.out.println("You have returned " + titleToReturn + ".");
                                break;
                            }
                        }
                        if(!bookReturned){
                            System.out.println("You have not borrowed " + titleToReturn + ".");
                        }
                        break;
                    case 3:
                        System.out.println("Enter the title of the book you want to search for: ");
                        String titleToSearch = scanner.nextLine();
                        management.searchBookByTitle(titleToSearch);
                        break;
                    case 4:
                        System.out.println("Enter the author of the book you want to search for: ");
                        String authorToSearch = scanner.nextLine();
                        management.searchBookByAuthor(authorToSearch);
                        break;
                    case 5:
                        System.out.println("Enter the ISBN of the book you want to search for: ");
                        String isbnToSearch = scanner.nextLine();
                        management.searchBookByISBN(isbnToSearch);
                        break;
                    case 6:
                        librarian.displayBookShelf();
                        break;
                    case 7:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }

    }
}
