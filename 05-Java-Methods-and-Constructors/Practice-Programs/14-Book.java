class Book {
    private String title;
    private String author;
    private double price;

    public Book() {
        this("Untitled", "Unknown", 0.0);
    }

    public Book(String title, String author) {
        this(title, author, 0.0);
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Book defaultBook = new Book();
        Book titleAndAuthor = new Book("Clean Code", "Robert C. Martin");
        Book completeBook = new Book("Effective Java", "Joshua Bloch", 799.0);

        defaultBook.display();
        System.out.println();
        titleAndAuthor.display();
        System.out.println();
        completeBook.display();
    }
}
