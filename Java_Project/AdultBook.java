package Java_Project;

// A subclass of the Book class representing books for adults
public class AdultBook extends Book
{
    // Constructor to initialize an Adult's Book with title, author, and price
    public AdultBook(String title, String author, double price)
    {
        super(title, author, price); // Call the constructor of the superclass (Book) to set these properties
    }

    @Override
    public String getCategory()
    {
        return "Adult"; // Always return "Adult" as the category for books of this type
    }
}
