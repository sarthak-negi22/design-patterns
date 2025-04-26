class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class Library {
    private Book[] books;
    private int size = 0;

    public Library(int capacity) {
        books = new Book[capacity];
    }

    public void addBook(Book book) {
        if(size < books.length) {
            books[size++] = book;
        } else {
            System.out.println("Library is full");
        }
    }

    public Book[] getBooks() {
        return books;
    }
}

public class IteratorDesignProblem {
    public static void main(String[] args) {
        Library library = new Library(3);
        library.addBook(new Book("Atomic Habbits"));
        library.addBook(new Book("System Design"));
        library.addBook(new Book("Bits and Bytes"));

        // directly accessing array
        for(Book book : library.getBooks()) {
            if(book != null)
            System.out.println("Book details: "+book.getTitle());
        }
    }
}
