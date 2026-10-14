public class Book {

    private int id;
    private String title;
    private String author;
    private String category;
    private boolean available;

    // Used for Question 17
    private boolean markedForWithdrawal;

    public Book(int id, String title, String author, String category, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = available;

        // By default, a book is not marked for withdrawal
        this.markedForWithdrawal = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Question 17
    public boolean isMarkedForWithdrawal() {
        return markedForWithdrawal;
    }

    public void setMarkedForWithdrawal(boolean markedForWithdrawal) {
        this.markedForWithdrawal = markedForWithdrawal;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", available=" + available +
                ", markedForWithdrawal=" + markedForWithdrawal +
                '}';
    }
}