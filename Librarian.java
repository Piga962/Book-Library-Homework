public class Librarian extends Person {
    private int employeeId;
    private Management management;

    public Librarian(String name, String address, String phoneNumber, String email, int employeeId, Management management) {
        super(name, address, phoneNumber, email);
        this.employeeId = employeeId;
        this.management = management;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void addBookToShelf(Book book) {
        management.addBookToShelf(book);
    }   

    public void removeBookFromShelf(Book book) {
        management.removeBookFromShelf(book);
    }

    public void addPatron(Patron patron) {
        management.addPatron(patron);
    }

    public void displayBookShelf() {
        management.displayBookShelf();
    }

    public void displayPatrons() {
        management.displayPatrons();
    }

}
