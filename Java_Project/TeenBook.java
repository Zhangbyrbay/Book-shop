package Java_Project;

// A subclass of the Book class representing books for teenagers
public class TeenBook extends Book
{
    // Constructor to initialize a Teen's Book with title, author, and price
    public TeenBook(String title, String author, double price)
    {
        super(title, author, price); // Call the constructor of the superclass (Book) to set these properties
    }

    @Override
    public String getCategory()
    {
        return "Teen"; // Always return "Teen" as the category for books of this type
    }
}
