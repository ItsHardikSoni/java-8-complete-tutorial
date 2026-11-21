import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private boolean issued;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    boolean issue() {
        if (issued) {
            return false;
        }
        issued = true;
        return true;
    }

    void returnBook() {
        issued = false;
    }

    String getTitle() {
        return title;
    }

    boolean isIssued() {
        return issued;
    }

    @Override
    public String toString() {
        return title + " by " + author + (issued ? " (issued)" : " (available)");
    }
}

class Member {
    String name;
    List<Book> borrowedBooks = new ArrayList<>();

    Member(String name) {
        this.name = name;
    }

    void borrow(Book book) {
        if (book.issue()) {
            borrowedBooks.add(book);
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is already issued.");
        }
    }

    void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
            System.out.println(name + " returned " + book.getTitle());
        }
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Book java = new Book("Java 8", "James Gosling");
        library.addBook(java);

        Member member = new Member("Anita");
        member.borrow(java);
        library.displayBooks();
        member.returnBook(java);
        library.displayBooks();
    }
}
