public class Main {

    public static void main(String[] args) {

        Book fictionBook = new Book(
                1,
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                "Fiction",
                true
        );

        Book cartoonBook = new Book(
                2,
                "Mickey Mouse",
                "Walt Disney",
                "Cartoon",
                true
        );

        Book scienceBook = new Book(
                3,
                "A Brief History of Time",
                "Stephen Hawking",
                "Science",
                true
        );

        Book historyBook = new Book(
                4,
                "timbuktu",
                "Yuval Noah Harari",
                "History",
                true
        );

        Book geographBook = new Book(
                101,
                "THE GLOBE",
                "F. Scott Fitzgerald",
                "GEOGRAPHY",
                false
        );


        LibraryManager libraryManager = new LibraryManager();


        // ==========================================
        // ADD BOOKS
        // ==========================================

        System.out.println("Adding books:");

        libraryManager.addBook(fictionBook);

        libraryManager.addBook(cartoonBook);

        libraryManager.addBook(scienceBook);

        libraryManager.addBook(geographBook);


        System.out.println("\nAll the books in the collection:");

        System.out.println(libraryManager.getBooks());


        // Add history book

        libraryManager.addBook(historyBook);

        System.out.println("\nAll the books in the collection:");

        System.out.println(libraryManager.getBooks());


        // ==========================================
        // FILTER BY CATEGORY
        // ==========================================

        System.out.println("\nBooks in Fiction category:");

        System.out.println(
                libraryManager.filterByCategory("FICTION")
        );


        // ==========================================
        // UPDATE BOOK
        // ==========================================

        System.out.println("\nUpdating book with ID 3:");

        libraryManager.updateBook(
                3,
                "Animation",
                false
        );

        System.out.println(
                libraryManager.getBooks()
        );


        // ==========================================
        // REMOVE BOOK BY ID
        // ==========================================

        libraryManager.removeBook(1);

        System.out.println(
                "\nThe remaining books after the removal:"
        );

        System.out.println(
                libraryManager.getBooks()
        );


        // ==========================================
        // BORROW BOOK
        // ==========================================

        System.out.println("\nBorrowing book with ID 2:");

        libraryManager.borrowBook(2);

        System.out.println(
                libraryManager.getBooks()
        );


        // Try to borrow the same book again

        System.out.println("\nTrying to borrow book 2 again:");

        libraryManager.borrowBook(2);


        // ==========================================
        // QUESTION 18
        // CHECK AVAILABILITY
        // ==========================================

        System.out.println("\nQUESTION 18 - CHECK AVAILABILITY:");

        // Check book ID 2
        libraryManager.checkAvailability(2);

        // Check a book that does not exist
        libraryManager.checkAvailability(50);


        // ==========================================
        // QUESTION 17
        // REMOVE WITHDRAWN BOOKS
        // ==========================================

        System.out.println("\nQUESTION 17 - REMOVE WITHDRAWN BOOKS:");

        // Mark THE GLOBE for withdrawal
        geographBook.setMarkedForWithdrawal(true);


        System.out.println(
                "\nBooks before removing withdrawn books:"
        );

        System.out.println(
                libraryManager.getBooks()
        );


        // Remove books marked for withdrawal

        libraryManager.removeWithdrawnBooks();


        System.out.println(
                "\nBooks after removing withdrawn books:"
        );

        System.out.println(
                libraryManager.getBooks()
        );
    }
}