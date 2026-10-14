import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class LibraryManager {

    List<Book> books;

    public LibraryManager() {
        this.books = new ArrayList<>();
    }

    // ADD BOOK
    public void addBook(Book book) {

        if (book.getAuthor().isEmpty()
                || book.getTitle().isEmpty()
                || book.getCategory().isEmpty()) {

            System.out.println(
                    "We can't add this book to the collection due to the emptiness of one of the attributes"
            );

            return;
        }

        for (Book existingBook : books) {

            if (existingBook.getId() == book.getId()) {

                System.out.println(
                        "The ID: " + book.getId() + " already exists"
                );

                return;
            }
        }

        books.add(book);

        System.out.println(
                "The book with ID: " + book.getId()
                        + " has been added to the collection"
        );
    }


    // GET ALL BOOKS
    public List<Book> getBooks() {
        return books;
    }


    // SEARCH BOOK BY ID
    public Book searchById(int id) {

        for (Book currentBook : books) {

            if (currentBook.getId() == id) {
                return currentBook;
            }
        }

        return null;
    }


    // SEARCH BOOK BY TITLE
    public List<Book> searchByTitle(String title) {

        List<Book> sametitle = new ArrayList<>();

        for (Book currentBook : books) {

            if (currentBook.getTitle().equals(title)) {
                sametitle.add(currentBook);
            }
        }

        return sametitle;
    }


    // SEARCH BOOK BY AUTHOR
    public List<Book> searchByAuthor(String authorname) {

        List<Book> sameAuthor = new ArrayList<>();

        for (Book currentBook : books) {

            if (currentBook.getAuthor().equals(authorname)) {
                sameAuthor.add(currentBook);
            }
        }

        return sameAuthor;
    }


    // FILTER BY CATEGORY
    public List<Book> filterByCategory(String category) {

        List<Book> categorizedBook = new ArrayList<>();

        for (Book currentBook : books) {

            if (currentBook.getCategory().equalsIgnoreCase(category)) {
                categorizedBook.add(currentBook);
            }
        }

        return categorizedBook;
    }


    // UPDATE BOOK
    public void updateBook(int id, String category, boolean available) {

        Book book = searchById(id);

        if (book != null) {

            book.setCategory(category);
            book.setAvailable(available);

            System.out.println("Book updated successfully.");

        } else {

            System.out.println("Book was not found.");
        }
    }


    // REMOVE BOOK BY ID
    public void removeBook(int id) {

        Book book = searchById(id);

        if (book != null) {

            books.remove(book);

            System.out.println("Book removed successfully.");

        } else {

            System.out.println("Book was not found.");
        }
    }


    // BORROW BOOK
    public void borrowBook(int id) {

        Book book = searchById(id);

        if (book == null) {

            System.out.println("Book was not found.");
            return;
        }

        if (book.isAvailable()) {

            book.setAvailable(false);

            System.out.println(
                    "The book = " + book.getTitle()
                            + " is borrowed right away"
            );

        } else {

            System.out.println(
                    "THE BOOK IS NOT AVAILABLE IN THE MEANTIME"
            );
        }
    }


    // ==================================================
    // QUESTION 17
    // REMOVE BOOKS MARKED FOR WITHDRAWAL
    // ==================================================

    public void removeWithdrawnBooks() {

        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {

            Book currentBook = iterator.next();

            if (currentBook.isMarkedForWithdrawal()) {

                System.out.println(
                        "Removing book: " + currentBook.getTitle()
                );

                iterator.remove();
            }
        }
    }


    // ==================================================
    // QUESTION 18
    // CHECK AVAILABILITY
    // ==================================================

    public void checkAvailability(int id) {

        Book book = searchById(id);

        // Check if the book exists
        if (book == null) {

            System.out.println(
                    "Book with ID " + id + " does not exist."
            );

            return;
        }

        // Check if the book is available
        if (book.isAvailable()) {

            System.out.println(
                    "Book: " + book.getTitle()
                            + " is available for borrowing."
            );

        } else {

            System.out.println(
                    "Book: " + book.getTitle()
                            + " exists, but it is not available for borrowing."
            );
        }
    }
}