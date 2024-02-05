/*
 * This Class extends the Product class for Book objects.
 */
public class Book extends Product {

    // Encapsulated variables.
    private String title = null;
    private String author = null;
    private String genre = null;
    private int numPages = -1;
    private int year = -1;

    // Class Constructor.
    public Book(int productID, String name, String description, double price, String title, String author, String genre, int numPages, int year) {
        super(productID, name, description, price);

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numPages = numPages;
        this.year = year;

    }

    // Getters and Setters for the encapsulated variables.
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getNumPages() {
        return numPages;
    }
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    // Override to add onto the superclass's toString method.
    @Override
    public String toString() {
        String result = super.toString();
        result += "\ntitle: " + ((this.title != null) ? this.title:"not set");
        result += "\nauthor: " + ((this.author != null) ? this.author:"not set");
        result += "\ngenre: " + ((this.genre != null) ? this.genre:"not set");
        result += "\nnumPages: " + ((this.numPages > -1) ? this.numPages:"not set");
        result += "\nyear: " + ((this.year > -1) ? this.year:"not set");
        result += "\n==== END OF PRODUCT ====\n";
        return result;
    }
    
}