package JavaBasics;

public class Book {
    String title;
    String author;
    int publicationYear;
    String isbn;

    public Book(String title, String author, int publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    public void displayBookInfo() {
        IO.println("Title: " + this.title);
        IO.println("Author: " + this.author);
        IO.println("Year: " + this.publicationYear);
        IO.println("ISBN: " + this.isbn);
    }
}
