package Java_Project;

// Class representing a book with basic properties like title, author, and price
public class Book
{
    private String title;
    private String author;
    private double price;

    // Constructor to initialize a book object with its title, author, and price
    public Book(String title, String author, double price)
    {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to get the title of the book
    public String getTitle()
    {
        return title;
    }

    // Method to get the author of the book
    public String getAuthor()
    {
        return author;
    }

    // Method to get the price of the book
    public double getPrice()
    {
        return price;
    }

    // Method to get the category of the book
    public String getCategory()
    {
        return "General"; // Return the default category as "General"
    }
}

