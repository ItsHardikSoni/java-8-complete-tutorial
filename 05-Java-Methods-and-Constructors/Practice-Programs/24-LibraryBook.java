class LibraryBook {
    private String title;
    private String author;
    private boolean issued;

    public LibraryBook(String title, String author) {
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public void issueBook() {
        if (issued) {
            System.out.println("\"" + title + "\" is already issued.");
        } else {
            issued = true;
            System.out.println("\"" + title + "\" issued successfully.");
        }
    }

    public void returnBook() {
        if (!issued) {
            System.out.println("\"" + title + "\" is already in the library.");
        } else {
            issued = false;
            System.out.println("\"" + title + "\" returned successfully.");
        }
    }

    public void displayStatus() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (issued ? "Issued" : "Available"));
    }

    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Head First Java", "Kathy Sierra");
        book.displayStatus();
        book.issueBook();
        book.issueBook();
        book.returnBook();
        book.displayStatus();
    }
}
