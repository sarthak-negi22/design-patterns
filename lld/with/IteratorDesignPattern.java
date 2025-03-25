interface Iterator<T> {
    boolean hasNext();
    T next();
}

class BookIterator implements Iterator<Book> {
    private Book[] books;
    private int index = 0;

    public BookIterator(Book[] books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return index < books.length && books[index] != null;
    }

    @Override
    public Book next() {
        return books[index++];
    }
}

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

    public Iterator<Book> iterator() {
        return new BookIterator(books);
    }
}

public class IteratorDesignPattern {
    public static void main(String[] args) {
        Library library = new Library(3);
        library.addBook(new Book("Atomic Habits"));
        library.addBook(new Book("System Design"));
        library.addBook(new Book("Matering c++"));

        Iterator<Book> iterator = library.iterator();

        while(iterator.hasNext()) {
            System.out.println("Book details:" +iterator.next().getTitle());
        }
    }
}
