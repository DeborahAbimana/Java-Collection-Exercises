import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class LibraryManager {

    List<Book> books;

    public LibraryManager() {
        this.books = new ArrayList<>();
    }

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



    public List<Book> getBooks() {
        return books;
    }


    
    public Book searchById(int id) {

        for (Book currentBook : books) {

            if (currentBook.getId() == id) {
                return currentBook;
            }
        }

        return null;
    }


    
    public List<Book> searchByTitle(String title) {

        List<Book> sametitle = new ArrayList<>();

        for (Book currentBook : books) {

            if (currentBook.getTitle().equals(title)) {
                sametitle.add(currentBook);
            }
        }

        return sametitle;
    }


    
    public List<Book> searchByAuthor(String authorname) {

        List<Book> sameAuthor = new ArrayList<>();

        for (Book currentBook : books) {

            if (currentBook.getAuthor().equals(authorname)) {
                sameAuthor.add(currentBook);
            }
        }

        return sameAuthor;
    }



    public List<Book> filterByCategory(String category) {

        List<Book> categorizedBook = new ArrayList<>();

        for (Book currentBook : books) {

            if (currentBook.getCategory().equalsIgnoreCase(category)) {
                categorizedBook.add(currentBook);
            }
        }

        return categorizedBook;
    }


    
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


    
    public void removeBook(int id) {

        Book book = searchById(id);

        if (book != null) {

            books.remove(book);

            System.out.println("Book removed successfully.");

        } else {

            System.out.println("Book was not found.");
        }
    }


    
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


    

    public void checkAvailability(int id) {

        Book book = searchById(id);

        
        if (book == null) {

            System.out.println(
                    "Book with ID " + id + " does not exist."
            );

            return;
        }

        
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