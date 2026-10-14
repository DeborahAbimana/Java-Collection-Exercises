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


        System.out.println("Adding books:");

        libraryManager.addBook(fictionBook);

        libraryManager.addBook(cartoonBook);

        libraryManager.addBook(scienceBook);

        libraryManager.addBook(geographBook);


        System.out.println("\nAll the books in the collection:");

        System.out.println(libraryManager.getBooks());


        

        libraryManager.addBook(historyBook);

        System.out.println("\nAll the books in the collection:");

        System.out.println(libraryManager.getBooks());


        

        System.out.println("\nBooks in Fiction category:");

        System.out.println(
                libraryManager.filterByCategory("FICTION")
        );


        

        System.out.println("\nUpdating book with ID 3:");

        libraryManager.updateBook(
                3,
                "Animation",
                false
        );

        System.out.println(
                libraryManager.getBooks()
        );


        

        libraryManager.removeBook(1);

        System.out.println(
                "\nThe remaining books after the removal:"
        );

        System.out.println(
                libraryManager.getBooks()
        );




        System.out.println("\nBorrowing book with ID 2:");

        libraryManager.borrowBook(2);

        System.out.println(
                libraryManager.getBooks()
        );


        

        System.out.println("\nTrying to borrow book 2 again:");

        libraryManager.borrowBook(2);




        System.out.println("\nQUESTION 18 - CHECK AVAILABILITY:");

        
        libraryManager.checkAvailability(2);

        
        libraryManager.checkAvailability(50);


        
        System.out.println("\nQUESTION 17 - REMOVE WITHDRAWN BOOKS:");

        
        geographBook.setMarkedForWithdrawal(true);


        System.out.println(
                "\nBooks before removing withdrawn books:"
        );

        System.out.println(
                libraryManager.getBooks()
        );


        
        libraryManager.removeWithdrawnBooks();


        System.out.println(
                "\nBooks after removing withdrawn books:"
        );

        System.out.println(
                libraryManager.getBooks()
        );
    }
}